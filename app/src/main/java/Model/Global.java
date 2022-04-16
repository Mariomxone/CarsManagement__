package Model;

public class Global {
        public static String getUser() {
                return user;
        }

        public static void setUser(String user) {
                Global.user = user;
        }

        public static String user;

        public static int getCarro() {
                return carro;
        }


        public static void setCarro(int carro) {
                Global.carro = carro;
        }

        public static int carro;
}
