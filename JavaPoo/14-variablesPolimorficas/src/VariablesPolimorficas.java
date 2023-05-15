public class VariablesPolimorficas {
//Las variables poliformicas son aquellas q3ue guardan un objecto
    public static void main(String[] args) {
        Optimista op1 = new Optimista();
        Pesimista pe1 = new Pesimista();
        Extrovertido e1 = new Extrovertido();
        Introvertido i1 = new Introvertido();
        //creando variables poliformicas.
        Personalidad objPersonalidades[] = new Personalidad[4];
        objPersonalidades[0] = op1;
        objPersonalidades[1] = pe1;
        objPersonalidades[2] = e1;
        objPersonalidades[3] = i1;
        
        objPersonalidades[0].hablar();
        objPersonalidades[1].hablar();
        objPersonalidades[2].hablar();
        objPersonalidades[3].hablar();
    }
    
}
