import kotlin.Any
import kotlin.String
import kotlin.Unit

public class iSize {
  public fun plusAssign(uint32size: String): Unit {
    	//returns Unit
        //{w=w+size;h=h+size;}
  }

  public fun minusAssign(uint32size: String): Unit {
    	//returns Unit
        //{w=w-size;h=h-size;}
  }

  public fun plus(`constiSize&size`: String): Any {
    	//returns iSize
        //{return(iSize(w+size.w,h+size.h));}
  }

  public fun plus(uint32size: String): Any {
    	//returns iSize
        //{return(iSize(w+size,h+size));}
  }

  public fun minus(uint32size: String): Any {
    	//returns iSize
        //{return(iSize(w-size,h-size));}
  }

  public fun equals(`constiSize&siz`: String): Any {
    	//returns bool
        //{return((w==siz.w)&&(h==siz.h));}
  }

  public fun equals(`constiSize&siz`: String): Any {
    	//returns bool
        //{return!operator==(siz);}
  }
}
