class iSize
{
public:
	inline void operator += (uint32 size)
	{
		w=w+size;
		h=h+size;
	}

	inline void operator -= (uint32 size)
	{
		w=w-size;
		h=h-size;
	}

	inline iSize operator + (const iSize& size) const
	{ return (iSize(w+size.w,h+size.h)); }

	inline iSize operator + (uint32 size) const
	{ return (iSize(w+size,h+size)); }

	inline iSize operator - (uint32 size) const
	{ return (iSize(w-size,h-size)); }

	inline bool operator== (const iSize &siz) const
	{ return ((w==siz.w) && (h==siz.h)); }

	inline bool operator!= (const iSize &siz) const
	{ return ! operator == ( siz ); }


};