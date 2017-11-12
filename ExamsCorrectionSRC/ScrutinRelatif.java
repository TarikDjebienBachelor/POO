package scrutin;

import java.util.*;

public class ScrutinRelatif implements Scrutin {

	private int nbInscrits;

	private List votesPossibles;

	private List lesVotes;

	private Map resultats;

	private boolean estClos;

	public ScrutinRelatif(List votesPossibles, int nbInscrits) {
		this.votesPossibles = votesPossibles;
		this.votesPossibles.add(Vote.BLANC);
		this.votesPossibles.add(Vote.NUL);
		this.nbInscrits = nbInscrits;
		this.lesVotes = new ArrayList();
		this.estClos = false;
	}

	public void afficheResultats() throws VoteNonClosException {
		if (this.estClos) {
			for (Iterator it = this.resultats.keySet().iterator(); it.hasNext();) {
				Vote v = (Vote) it.next();
				System.out.println(v + " a recu " + ((Integer) this.resultats.get(v)).intValue()
						+ " suffrages");
			}
		} else {
			throw new VoteNonClosException();
		}
	}

	public void ajouteVote(Vote v) throws VoteClosException {
		if (!this.estClos) {
			this.lesVotes.add(v);
		} else {
			throw new VoteClosException();
		}
	}

	public void clot() {
		this.estClos = true;
		this.resultats = new HashMap();
		// on initialise les résultats
		for (Iterator it = this.votesPossibles.iterator(); it.hasNext();) {
			this.resultats.put(it.next(), new Integer(0));
		}
		// on comtabilise les votes
		for (Iterator it = this.lesVotes.iterator(); it.hasNext();) {
			Vote v = (Vote) it.next();
			this.resultats.put(v, new Integer(((Integer) this.resultats.get(v)).intValue() + 1));
		}
	}

	public boolean estClos() {
		return this.estClos;
	}

	public Vote getVainqueur() throws VoteNonClosException {
		Vote voteMax = null;
		int nbVoixMax = 0;
		int nbBlancsOuNuls = 0;
		if (this.estClos) {
			for (Iterator it = this.resultats.keySet().iterator(); it.hasNext();) {
				Vote v = (Vote) it.next();
				if (v == Vote.BLANC || v == Vote.NUL || !this.votesPossibles.contains(v)) {
					nbBlancsOuNuls = nbBlancsOuNuls + ((Integer) this.resultats.get(v)).intValue();
				} else {
					if (nbVoixMax < ((Integer) this.resultats.get(v)).intValue()) {
						voteMax = v;
						nbVoixMax = ((Integer) this.resultats.get(v)).intValue();
					}
				}
			}
			if (nbVoixMax > this.nbInscrits * 0.15) { // majorité relative > 15%
																	// des inscrits
				return voteMax;
			} else { // pas de vainqueur
				return null;
			}

		} else {
			throw new VoteNonClosException();
		}
	}

	public List getVotesPossibles() {
		return this.votesPossibles;
	}

}
