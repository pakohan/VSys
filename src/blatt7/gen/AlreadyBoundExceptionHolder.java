package blatt7.gen;

/**
* aufgabe7/blatt7.gen/AlreadyBoundExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from forum.idl
* Sonntag, 9. Juni 2013 14:58 Uhr MESZ
*/

public final class AlreadyBoundExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public blatt7.gen.AlreadyBoundException value = null;

  public AlreadyBoundExceptionHolder ()
  {
  }

  public AlreadyBoundExceptionHolder (blatt7.gen.AlreadyBoundException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = blatt7.gen.AlreadyBoundExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    blatt7.gen.AlreadyBoundExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return blatt7.gen.AlreadyBoundExceptionHelper.type ();
  }

}
