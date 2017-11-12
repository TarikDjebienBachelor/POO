package scrutin;

import java.util.List;

public interface Scrutin {
	public List getVotesPossibles();
	public void ajouteVote(Vote v)throws VoteClosException;
	public boolean estClos();
	public void clot();
	public Vote getVainqueur() throws VoteNonClosException;
	public void afficheResultats() throws VoteNonClosException;
}
