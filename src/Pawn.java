/*
 * Classe du Pion
 *
 * @author	Mathis Dankou
 * @version	15/04/2019
 */

public class Pawn extends Piece
{
	/**
	 * Constructeur du pion
	 */
	public Pawn(int color)
	{
		super(color,"♙","♟");
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
	public boolean movePossible(ChessBoard b, int x1, int y1, int x2, int y2)
	{
		int dx = x2 - x1, dy = y2 - y1;
		
		if (dy == 0 || Math.abs(dx) + Math.abs(dy) > 2)
			return false; // déplacement horizontal interdit ou rayon impossible
		else if (Math.abs(dy) == 2)
		{
			if (this.getColor() == 0)
			{
				if (dy > 0) return false; // déplacement vertical interdit
				else if (y1 != 6 || b.isEmpty(x2, 5) == false)
					return false;
			}
			else
			{
				if (dy < 0) return false; // déplacement vertical interdit
				else if (y1 != 1 || b.isEmpty(x2, 2) == false)
					return false;
			}
		}
		if (dx == 0 && b.isEmpty(x2, y2) == false)
			return false;
		else if (dx != 0 && b.isEmpty(x2, y2) == true) return false;
		return true;
	}
}
