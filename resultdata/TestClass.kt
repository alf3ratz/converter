import kotlin.Boolean
import kotlin.String
import kotlin.Unit

public class ISize {
  public fun plusAssign(uint32size: String): Unit {
    	//returns Unit
        //{w=w+size;h=h+size;}
  }

  public fun minusAssign(uint32size: String): Unit {
    	//returns Unit
        //{w=w-size;h=h-size;}
  }

  public fun plus(`constiSize&size`: String): ISize {
    	//returns ISize
        //{return(iSize(w+size.w,h+size.h));}
  }

  public fun plus(uint32size: String): ISize {
    	//returns ISize
        //{return(iSize(w+size,h+size));}
  }

  public fun minus(uint32size: String): ISize {
    	//returns ISize
        //{return(iSize(w-size,h-size));}
  }

  public fun equals(`constiSize&siz`: String): Boolean {
    	//returns Boolean
        //{return((w==siz.w)&&(h==siz.h));}
  }

  public fun equals(`constiSize&siz`: String): Boolean {
    	//returns Boolean
        //{return!operator==(siz);}
  }
}
