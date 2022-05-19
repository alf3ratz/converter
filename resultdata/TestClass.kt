import kotlin.Boolean
import kotlin.Unit

public class ISize {
  public fun plusAssign(size: Uint32): Unit {
    var w: `W=w+size` = w + size
    var h: `H=h+size` = h + size
  }

  public fun minusAssign(size: Uint32): Unit {
    var w: `W=w-size` = w - size
    var h: `H=h-size` = h - size
  }

  public fun plus(`size$$const`: ISize): ISize {
    var size: ISize = `size$$const`
    return (size + h)
  }

  public fun plus(size: Uint32): ISize = (h + size)

  public fun minus(size: Uint32): ISize = (h - size)

  public fun equals(`siz$$const`: ISize): Boolean {
    var siz: ISize = `siz$$const`
    return ((h))
  }

  public fun notEquals(`siz$$const`: ISize): Boolean {
    var siz: ISize = `siz$$const`
    return siz
  }
}
