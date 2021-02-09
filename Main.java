public class Main {

    public static void main(String[] args) {

        String pleinDeLignes = "----------------------------------------------------\n";
        String bienvenue = "---   Bienvenue au jeu de roche-papier-ciseau    ---\n";

        Pep8.stro(pleinDeLignes);
        Pep8.stro(bienvenue);
        Pep8.stro(pleinDeLignes);

        String qManches = "combien de manches voulez vous jouer?\n";
        Pep8.stro(qManches);


        //prend le nombre de manches choisies et le met dans un int
        int manches = Pep8.deci();
        Pep8.chari();

        //on va convertir en binaire et acceder au dernier bit, comme en Assembleur
        //en Assembleur il y a une maniere plus facile de convertir en binaire
        //si c'est pair, +1
        String mancheBinaire = Integer.toBinaryString(manches);
        if (mancheBinaire.endsWith("0")){
            manches ++;
        }


        String strNbManches = "il reste ";
        String strNbManchesSuite = " manche(s) a jouer.\n";

        // Collage pour ecrire "il reste x manches a jouer"
        Pep8.stro(strNbManches);
        Pep8.deco(manches);
        Pep8.stro(strNbManchesSuite);
        //Strings pour la question de choisir r p c
        String joueurUn = "JOUEUR 1";
        String joueurDeux = "JOUEUR 2";
        String questionChoix = ", quel est votre choix? [r/p/c]\n";

        //Match nul, ou gagnant
        String mancheNulle = "Manche nulle...\n\n";
        String aGagne = " a gagne cette manche! Score: ";
        //on va commencer chaque score a 0, pour pouvoir augmenter plus tard
        int scoreJoueurUn = 0;
        int scoreJoueurDeux = 0;
        String gagnant = "";
        String erreurEntree = "Erreur d'entree! Programme termine";

        //condition pour fin de partie, en assembleur on ne peut que diviser par deux ?
        //donc tant que la partie n'est pas fini, on joue
        while(scoreJoueurUn <= (manches / 2) && scoreJoueurDeux <= (manches / 2) ) {
            Pep8.stro(joueurUn);
            Pep8.stro(questionChoix);
            char choixJoueurUn = Pep8.chari();
            //on verifie si le choix est r, p, ou c
            //on verifie le deuxieme chari pour etre sur que c est le enter et pas plus de texte
            char verif = Pep8.chari();
            if (verif != '\n' || (choixJoueurUn != 'r' && choixJoueurUn != 'p' && choixJoueurUn != 'c') ){
                Pep8.stro(erreurEntree);
                Pep8.stop();
            }
            // la question pour le joueur 2 maintenant
            Pep8.stro(joueurDeux);
            Pep8.stro(questionChoix);
            char choixJoueurDeux = Pep8.chari();
            //le verif verifie le 2e char qui doit etre un enter, et choixJoueurDeux doit etre = r p ou c
            verif = Pep8.chari();
            if (verif != '\n'|| (choixJoueurDeux != 'r' && choixJoueurDeux != 'p' && choixJoueurDeux != 'c')){
                Pep8.stro(erreurEntree);
                Pep8.stop();
            }
            //on vide la variable gagnant
            gagnant = null;
            //et voici tous les scenarios possibles, incluant les matchs nuls
            if (choixJoueurUn == 'r') {
                if (choixJoueurDeux == 'r') {
                    Pep8.stro(mancheNulle);
                } else if (choixJoueurDeux == 'p') {
                    scoreJoueurDeux++;
                    gagnant = joueurDeux;
                } else if (choixJoueurDeux == 'c') {
                    scoreJoueurUn++;
                    gagnant = joueurUn;
                }
            } else if (choixJoueurUn == 'p') {
                if (choixJoueurDeux == 'r') {
                    scoreJoueurUn++;
                    gagnant = joueurUn;
                } else if (choixJoueurDeux == 'p') {
                    Pep8.stro(mancheNulle);
                } else if (choixJoueurDeux == 'c') {
                    scoreJoueurDeux++;
                    gagnant = joueurDeux;
                }
            } else if (choixJoueurUn == 'c') {
                if (choixJoueurDeux == 'r') {
                    scoreJoueurDeux++;
                    gagnant = joueurDeux;
                } else if (choixJoueurDeux == 'p') {
                    scoreJoueurUn++;
                    gagnant = joueurUn;
                } else if (choixJoueurDeux == 'c') {
                    Pep8.stro(mancheNulle);
                }
            }
            //s'il y a un gagnant, alors on avance, on affiche les scores aussi
            if (gagnant != null) {
                Pep8.stro(gagnant);
                Pep8.stro(aGagne);
                Pep8.deco(scoreJoueurUn);
                Pep8.charo('-');
                Pep8.deco(scoreJoueurDeux);
                Pep8.charo('\n');
                Pep8.charo('\n');
            }

        }
        // le gagnant final est soit joueur un ou joueur deux, dependemment des scores finaux
        if (scoreJoueurUn > scoreJoueurDeux){
            gagnant = joueurUn;
        } else {
            gagnant = joueurDeux;
        }

        //on affiche le message de felicitations, ainsi que le score final
        String messageGagnantMatch = " A GAGNE LE MATCH! FELICITATIONS!\n";
        String scoreFinal = "SCORE FINAL: \n";
        //la variable 'gagnang' contient deja le gagnant final
        Pep8.stro(gagnant);
        Pep8.stro(messageGagnantMatch);
        Pep8.stro(scoreFinal);
        Pep8.deco(scoreJoueurUn);
        Pep8.charo('-');
        Pep8.deco(scoreJoueurDeux);

    }
}
