public enum EnumTest {
    APPROVED{

        @Override
        public void sampleMethod() {
            System.out.println(this.name());
        }
    },
    PENDING{

        @Override
        public void sampleMethod() {
            System.out.println(this.name());
        }
    },
    DENIED{

        @Override
        public void sampleMethod() {
            System.out.println(this.name());
        }
    };

    public abstract void sampleMethod();
}