public class JsonFormat {
    private String jsonOrigin;

    public JsonFormat(String jsonOrigin) {
        this.jsonOrigin = jsonOrigin;
    }

    public String toFormatString() {
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonOrigin.length(); i++) {
            last = current;
            current = jsonOrigin.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndent(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndent(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndent(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        return sb.toString();
    }
    public void addIndent(StringBuilder sb,int indent){
        for(int i=0;i<indent;i++){
            sb.append('\t');
        }
    }
}
