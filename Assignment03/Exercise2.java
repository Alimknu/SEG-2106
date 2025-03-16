import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercise2 {

    private String token = " ";
    private BufferedReader br;

    public Exercise2(File inputFile) {
        try {
            br = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getNextToken() {
        String line = "";

        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line != null ? line : "";
    }

    public boolean parse() {
        token = getNextToken();

        if (!program() || !token.equals("$")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean program() {
        if (token.equals("{")) {
            token = getNextToken();
            if (statementList() == false) {
                return false;
            } else {
                if (token.equals("}")) {
                    token = getNextToken();
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public boolean statementList() {
        if (statement() == false) {
            return false;
        } else if (token.equals(";")) {
            token = getNextToken();
            return statementListPrime();
        } else {
            return false;
        }
    }

    public boolean statementListPrime() {
        if (token.equals("}")) {
            return true;
        } else {
            return statementList();
        }
    }

    public boolean statement() {
        if (token.equals("call")) {
            token = getNextToken();
            if (token.equals(":")) {
                token = getNextToken();
                return procedureCall();
            }
        } else if (token.equals("compute")) {
            token = getNextToken();
            if (token.equals(":")) {
                token = getNextToken();
                return expression();
            }
        }

        return false;

    }

    public boolean procedureCall() {
        if (token.equals("id")) {
            token = getNextToken();
            if (token.equals("(")) {
                token = getNextToken();
                if (parameters()) {
                    if (token.equals(")")) {
                        token = getNextToken();
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean parameters() {
        if (factor()) {
            return parametersPrime();
        }

        else {
            return false;
        }
    }

    public boolean parametersPrime() {
        if (token.equals(",")) {
            token = getNextToken();
            return parameters();
        } else if (token.equals(")")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean expression() {
        if (token.equals("id")) {
            token = getNextToken();
            if (token.equals("=")) {
                token = getNextToken();
                if (factor()) {
                    return expressionPrime();
                } else {
                    return false;
                }
            }
        }

        return false;

    }

    public boolean expressionPrime() {
        if (token.equals("+")) {
            token = getNextToken();
            return factor();
        }

        else if (token.equals("-")) {
            token = getNextToken();
            return factor();
        }

        else if (token.equals(";")) {
            return true;
        }

        else {
            return false;
        }

    }

    public boolean factor() {
        if (token.equals("id")) {
            token = getNextToken();
            return true;
        }

        else if (token.equals("num")) {
            token = getNextToken();
            return true;
        }

        else {
            return false;
        }
    }

    public static void main(String[] args) {

        String filepath = args[0];

        File file = new File(filepath);

        if (file.isFile()) {
            Exercise2 parser = new Exercise2(file);

            boolean result = parser.parse();

            if (result) {
                System.out.println("SUCCESS: the code has been successfully parsed");
            } else {
                System.out.println("ERROR: the code contains a syntax mistake");
            }
        }

        else {
            System.out.println("ERROR: the specified path does not exist or does not belong to a file");
        }

    }
}
