package scrutin;

import java.util.*;

public class VoteMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List votesReferendum = new ArrayList();
		votesReferendum.add(Vote.OUI);
		votesReferendum.add(Vote.NON);
		Scrutin referendum = new ScrutinMajoritaire(votesReferendum, 110);
		//Scrutin referendum = new ScrutinRelatif(votesReferendum, 110);
		Random alea = new Random();
		try {
			for (int i = 0; i < 100; i++) { // mettre 30 pour tester ScrutinRelatif
				if (alea.nextBoolean()) {
					referendum.ajouteVote(Vote.OUI);
				} else {
					referendum.ajouteVote(Vote.NON);
				}
			}
		} catch (VoteClosException e) {
			e.printStackTrace();
		}
		referendum.clot();
		try {
			referendum.afficheResultats();
			System.out.println(referendum.getVainqueur()+" a gagne");
		} catch (VoteNonClosException e) {
			e.printStackTrace();
		}
	}

}
