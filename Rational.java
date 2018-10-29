package lab5;

import java.util.Iterator;

public class Rational implements Comparable<Rational>, Iterable<Object>, Iterator<Object>
{

	int a=1,b=1;
	
	public Rational()
	{
		this.a=1;
		this.b=1;
	}
	public Rational(int n)
	{
		this.a=n;
	}
	public Rational(int n, int m)
	{
		assert(m!=0);
		this.a=n;
		this.b=m;
		this.Simplify();
	}
	public Rational(Rational f)
	{
		this.a=f.a;
		this.b=f.b;
	}
	public Rational(String str)
	{
		assert(str.length()!=3);
		this.a=(int)str.charAt(0);
		this.b=(int)str.charAt(2);
	}
	private void Simplify()
	{
		int tmp1 = Math.abs(this.a);
		int tmp2 = Math.abs(this.b);
		while (tmp1 != tmp2)
		{
			if (tmp1>tmp2)
				tmp1 = tmp1 - tmp2;
			else
				tmp2 = tmp2 - tmp1;
		}
		if (tmp1 != 1)
		{
			b = b / tmp1;
			a = a / tmp1;
		}
		else
		{
			b=b/tmp2;
			a=a/tmp2;
		}
	}
	public Rational reverse()
	{
		Rational h = new Rational(this);
		h.a=this.b;
		h.b=this.a;
		return h;
	}
	public Rational add(Rational f)
	{
		Rational h=new Rational(this);
		h.a=h.a*f.b+f.a*h.b;
		h.b=h.b*f.b;
		h.Simplify();
		return h;
	}
	public Rational addInt(int f)
	{
		Rational h=new Rational(this);
		h.a=h.a+f*h.b;
		h.Simplify();
		return h;
	}
	public Rational sub(Rational f)
	{
		Rational h=new Rational(this);
		h.a=h.a*f.b-f.a*h.b;
		h.b=h.b*f.b;
		h.Simplify();
		return h;
	}
	public Rational subInt(int f)
	{
		Rational h=new Rational(this);
		h.a=h.a-f*h.b;
		h.Simplify();
		return h;
	}
	public Rational mult(Rational f)
	{
		Rational h = new Rational(this);
		h.a=h.a*f.a;
		h.b=h.b*f.b;
		h.Simplify();
		return h;
	}
	public Rational multInt(int f)
	{
		Rational h=new Rational(this);
		h.a=h.a*f;
		h.Simplify();
		return h;
	}
	public Rational div(Rational f)
	{
		Rational h = new Rational(this);
		h.a=h.a*f.b;
		h.b=h.b*f.a;
		h.Simplify();
		return h;
	}
	public Rational divInt(int f)
	{
		Rational h=new Rational(this);
		h.b=h.b*f;
		h.Simplify();
		return h;
	}
	public String toString()
	{
		String s=new String();
		if(a==0)
			s="0";
		else
			if(b==1)
				s=String.valueOf(a);
			else
			{
				s=String.valueOf(a)+"/"+String.valueOf(b);
			}
		return s;
	}
	 int iterator_idx = 0;
	 public void remove()
	 {
		 
	 }
     public void reset() {iterator_idx = 0;}
	@Override
	public boolean hasNext() {return iterator_idx > 1 ? false: true;}
	@Override
	 public Object next() {             
        if ( iterator_idx == 0 ) {
             iterator_idx++;
             return a;
        }
        else if ( iterator_idx == 1 ) {
             iterator_idx++;
             return new Integer( b );
        }
        else {
             reset();
             return null;
        }
  }
	@Override
	public Iterator<Object> iterator() {return this;}
	public int compareTo(Rational in) 
	{
		int cmp1=this.a*in.b;
		int cmp2=this.b*in.a;
		if(cmp1<cmp2)
			return -1;
		if(cmp1>cmp2)
			return 1;
		return 0;
	}
	public int compareA(Rational in)
	{
		int result = a-in.a;
		if(result != 0)
		{
			return (int) result / Math.abs( result );
		}
		return 0;
	}
	public int compareB(Rational in)
	{
		int result = b-in.b;
		if(result!=0)
		{
			return (int) result/Math.abs(result);
		}
		return 0;
	}
}
