/*
 * Classe de la tour
 *
 * @author	Franck Naze
 * @version	16/03/2019
 */

public class Rook extends Piece
{
	/**
	 * Constructeur du roi
	 * @param color la couleur de la pièce
	 */
	public	Rook(int color)
	{
		// Affectation des sprites
		super(color,"♖","♜");
	}
	
	/**
	 * Cette méthode permet à la pièce de se déplacer
	 * @param	b le plateau de jeu
	 * @param	x1 la position x de départ de la pièce
	 * @param	y1 la position y de départ de la pièce
	 * @param	x2 la position x de d'arrivé de la pièce
	 * @param	y2 la position y de d'arrivé de la pièce
	 * @return	un boolean indiquant si le mouvement est possible ou non
	 */
	@Override
	public boolean	movePossible(ChessBoard b, int x1, int y1, int x2, int y2)
	{
		int dx;
		int dy;
		
		dx=Math.abs(x2 - x1);
		dy=Math.abs(y2 - y1);
		
		if(dx>0 && dy>0) return false;//deplacement vertical et horizontal à la fois bloquée 
		
			if(dx!=0)
			{
				while(x1 != x2)
				{
				    if(x1<x2)
				    {
						x1+=1;
						if((x1==x2))
						{
						if (b.isEmpty(x2, y2) == false && b.getPieceColor(x2, y2) == this.getColor()) return false;
						else
						return true;
					    }
					    if(b.isEmpty(x1,y1)==false)return false;
					}
					if(x1>x2)
					{
						x1-=1;
						if(x1==x2)
						{
						if (b.isEmpty(x2, y2) == false && b.getPieceColor(x2, y2) == this.getColor()) return false;
						else
						return true;
					    }
					    if(b.isEmpty(x1,y1)==false)return false;
					}
				  }
			}
			if(dy!=0)
			{
				while(y1 != y2)
				{
					if(y1<y2)
					{
					 y1+=1;
						if((y1==y2))
						{
						if (b.isEmpty(x2, y2) == false && b.getPieceColor(x2, y2) == this.getColor()) return false;
						else
						return true;
					    }
					    if(b.isEmpty(x1,y1)==false)return false;
					}
					else
					{
						y1-=1;
						if((y1==y2))
						{
						if (b.isEmpty(x2, y2) == false && b.getPieceColor(x2, y2) == this.getColor()) return false;
						else
					    return true;
					    }
					    if(b.isEmpty(x1,y1)==false)return false;
					}
				}
			}	
		
		return false;
	}
}
