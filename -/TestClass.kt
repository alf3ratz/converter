import kotlin.Boolean
import kotlin.Int
import kotlin.Unit

public class ISize {
  public fun plusAssign(size: Int): Unit {
    	//returns Unit
        //{w=w+size;h=h+size;}
  }

  public fun minusAssign(size: Int): Unit {
    	//returns Unit
        //{w=w-size;h=h-size;}
  }

  public fun plus(size: ISize): ISize {
    	//returns ISize
        //{return(iSize(w+size.w,h+size.h));}
  }

  public fun plus(size: Int): ISize {
    	//returns ISize
        //{return(iSize(w+size,h+size));}
  }

  public fun minus(size: Int): ISize {
    	//returns ISize
        //{return(iSize(w-size,h-size));}
  }

  public fun equals(siz: ISize): Boolean {
    	//returns Boolean
        //{return((w==siz.w)&&(h==siz.h));}
  }

  public fun equals(siz: ISize): Boolean {
    	//returns Boolean
        //{return!operator==(siz);}
  }
}
