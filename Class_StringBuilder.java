public class Class_StringBuilder{
    public static void main(String[] args){

        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a'; ch <= 'z'; ch++){
            sb.append(ch);
        }
        System.out.println(sb);

        StringBuilder letter = new StringBuilder("hi, i am shraddha");
        letter.setCharAt(0, Character.toUpperCase(letter.charAt(0)));
        for(int i = 1; i < letter.length(); i++){
            if(letter.charAt(i) == ' '){
                char nextChar = letter.charAt(i+1);
                letter.setCharAt(i+1, Character.toUpperCase(nextChar));
            }
        }
        System.out.println(letter);


        String str = "aaabbcccdd";
        String compress = "";
        for(int i = 0; i< str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            compress += str.charAt(i);
            if(count > 1){
                compress += count.toString();
            }
        }
        System.out.println(compress);
    }
}
