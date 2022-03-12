import com.squareup.kotlinpoet.TypeVariableName
import kotlin.String
import kotlin.Unit

public class iSize {
  public fun plusAssign(uint32size: String): Unit {
    //{w=w+size;h=h+size;}
  }

  public fun minusAssign(uint32size: String): Unit {
    //{w=w-size;h=h-size;}
  }

  public fun plus(`constiSize&size`: String): TypeVariableName {
    //{return(iSize(w+size.w,h+size.h));}
  }

  public fun plus(uint32size: String): TypeVariableName {
    //{return(iSize(w+size,h+size));}
  }

  public fun minus(uint32size: String): TypeVariableName {
    //{return(iSize(w-size,h-size));}
  }

  public fun equals(`constiSize&siz`: String): TypeVariableName {
    //{return((w==siz.w)&&(h==siz.h));}
  }

  public fun equals(`constiSize&siz`: String): TypeVariableName {
    //{return!operator==(siz);}
  }
}
