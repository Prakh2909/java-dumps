public class HelloWorld  {
    public static void main(String[] args) {

        Bird a1 = new Bird();
        a1.getVoice("Pigeon");
        a1.getParentClass();
        Animal.sayHelloBird("Prakhar");
        a1.getHabitat();

        Animal a2 = new Animal() {
            @Override
            public void getVoice(String name){
                System.out.println("I am not "+ name);
            }
        };

        a2.getVoice("Prakhar");

        Animal a3 = (String name) -> {
            System.out.println("How are you");
        };

        a3.getVoice("Prakhar");
    }
}

// @FunctionalInterface
interface Animal { 

    void getVoice(String name);

    // void getHabitat();
    
    default void getParentClass(){
        System.out.println(this.getClass());
    }

    static void sayHelloBird(String name){
        System.out.println("Hello "+ name);
    }
}

class Bird implements Animal {
    public void getVoice(String name){
        System.out.println("I am "+ name);
    }

    public void getHabitat(){
        System.out.println("Sky");
    }
}
