package Conf;

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

        public static int getUserId() {
                return userId;
        }

        public static void setUserId(int userId) {
                Global.userId = userId;
        }

        public static int userId;
}
