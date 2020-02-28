import java.util.*;

public class Main_reseau_fibre {    
    public static void main(String[] args){
        
        int nbSommets = 7;
        
        // matrice des distances entre sommets
        int [][] matDist = {
            { 0, 30, 40, 50, 20, 50, 20},
            {30,  0, 30,  0, 50,  0,  0},
            {40, 30,  0, 20, 50,  0,  0},
            {50,  0, 20,  0, 40,  0,  0},
            {20, 50, 50, 40,  0, 40, 30},
            {50,  0,  0,  0, 40,  0,  0},
            {20,  0,  0,  0, 30,  0,  0}};
        
        
        // representation de l'ensemble S de l'algorithme
        // par la liste suivante:
        ArrayList<Arete> lesAretes = new ArrayList<Arete>();
        
        // construction de l'ensemble des aretes a partir de
        // la matrice de distances
        for(int i=0;i<nbSommets-1;i++){
            for(int j=i+1;j<nbSommets;j++){
                if (matDist[i][j] != 0){
                    Arete uneArete = new Arete(i,j,matDist[i][j]);
                    lesAretes.add(uneArete);
                    
           //         System.out.println(uneArete); // Pour voir les aretes dans la console
                    
                }
            }
        }

        // representation de l'ensemble R de l'algorithme
        // par la liste suivante:
        ArrayList<Integer> lesSommetsRejoints = new ArrayList<Integer>();
        // ATTENTION c'est bien Integer et non int
        
        // initialisation
        lesSommetsRejoints.add(0);
        
        // Algorithme
        int poids = 0;
        int distance = 100;
        Arete monArete = new Arete (0,0,0);
        
        while (lesSommetsRejoints.size()!=7) {
			for (int i=0; i<lesSommetsRejoints.size(); i++){
				for (int j=0; j<lesAretes.size(); j++){
					///On veut que l'arete existe et qu'elle soit la plus petite. On la stocke dans monArete
					if(0<lesAretes.get(j).poids && lesAretes.get(j).poids<distance){
						distance=lesAretes.get(j).poids;
						monArete=lesAretes.get(j);
					}
				}
			}
			///On veut aouter le bon sommet à la liste lesSommetsRejoints
			if (lesSommetsRejoints.contains(monArete.sommetA)){
				lesSommetsRejoints.add(monArete.sommetB);
				System.out.println(monArete+"on a ajoute le sommet B");
				poids = poids + distance;
			} else {
				lesSommetsRejoints.add(monArete.sommetA);
				System.out.println(monArete+"on a ajoute le sommet A");
				poids = poids + distance;
			}
			System.out.println(poids);
		}
        
    }
}
