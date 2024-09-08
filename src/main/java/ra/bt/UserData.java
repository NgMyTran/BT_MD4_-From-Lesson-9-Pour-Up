package ra.bt;

    public class UserData {
        private int id;
        private String name;
        private String email;
        private int age;

        public UserData(int id, String name, String email, int age) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }
    }


