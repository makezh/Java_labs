import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

// <Chain> ::= IDENT <Tail>
// <Tail>::= . IDENT ( <Arg> ) <Tail> | ε
// <Arg>::= NUMBER | STRING | <Chain>

public class Parser {
    public static void main(String[] args) {
        String expressionText = "a.mul(5).sub(b.div(c))";
        System.out.println("Text = " + expressionText);
        System.out.println(Chain(new LexemeBuffer(lexAnalyze(expressionText))));
//        List<Lexeme> lexemes = lexAnalyze(expressionText);
//        System.out.println(lexemes);
    }

    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET, DOT,
        IDENT, NUMBER, STRING,
        EOF;
    }

    public static class Lexeme {
        LexemeType type;
        String value;
        int line, col;

        public Lexeme (LexemeType type, String value, int line, int column) {
            this.type = type;
            this.value = value;
            this.line = line;
            this.col = column;
        }

        public Lexeme (LexemeType type, Character value, int line, int column) {
            this.type = type;
            this.value = value.toString();
            this.line = line;
            this.col = column;
        }

        @Override
        public String toString() {
            return "\nLexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    ", line=" + line +
                    ", column=" + col +
                    '}';
        }
    }

    public static class LexemeBuffer {
        private int pos;

        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public Lexeme getPos() {
            return lexemes.get(pos);
        }
    }

    public static List<Lexeme> lexAnalyze(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0, line = 0, col = 0;
        while (pos < expText.length()) {
            char c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c, line, col));
                    pos++;
                    col++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c, line, col));
                    pos++;
                    col++;
                    continue;
                case '.':
                    lexemes.add(new Lexeme(LexemeType.DOT, c, line, col));
                    pos++;
                    col++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            col++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString(), line, col));
                    } else if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')) {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            col++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A'));
                        if (c == '.' || c == '(')
                            lexemes.add(new Lexeme(LexemeType.IDENT, sb.toString(), line, col));
                        else
                            lexemes.add(new Lexeme(LexemeType.STRING, sb.toString(), line, col));
                    } else {
                        if(c == '\n') {
                            pos++;
                            line++;
                            col = 0;
                            continue;
                        }
                        if (c != ' ') {
                            throw new RuntimeException("syntax error at (" + (line + 1) + ", " + (col + 1) + ")" );
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, "", line, col));
        return lexemes;
    }

    // <Chain> ::= IDENT <Tail>
    // <Tail>::= . IDENT ( <Arg> ) <Tail> | ε
    // <Arg>::= NUMBER | STRING | <Chain>


    public static String Chain(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.IDENT) {
            return lexeme.value+ ' ' + Tail(lexemes);
        }
        throw new RuntimeException("syntax error at (" + lexeme.line
                + ", " + lexeme.col + ") ");
    }

    public static String Tail(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if(lexeme.type == LexemeType.DOT) {
            lexeme = lexemes.next();
            if(lexeme.type == LexemeType.IDENT) {
                lexeme = lexemes.next();
                if(lexeme.type == LexemeType.LEFT_BRACKET) {
                    String arg = Arg(lexemes);
                    if(lexemes.next().type != LexemeType.RIGHT_BRACKET) {
                        lexemes.back();
                        throw new RuntimeException("syntax error at (" + lexemes.getPos().line
                                + ", " + lexemes.getPos().col + ")");
                    }
                    return ". <Tail> ( " + arg + ") " + Tail(lexemes);
                }
            }
        }
        lexemes.back();
        return "";
    }

    public static String Arg(LexemeBuffer lexemes){
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case NUMBER, STRING:
                    return  "<Arg> ";
                case IDENT:
                    lexemes.back();
                    return Chain(lexemes);
                default:
                    throw new RuntimeException("syntax error at (" + lexemes.getPos().line
                        + ", " + lexemes.getPos().col + ")");
            }
        }
}
