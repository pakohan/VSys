package blatt7.gen;


/**
* aufgabe7/blatt7.gen/CorbaForumViewPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from forum.idl
* Sonntag, 9. Juni 2013 14:58 Uhr MESZ
*/

public abstract class CorbaForumViewPOA extends org.omg.PortableServer.Servant
 implements blatt7.gen.CorbaForumViewOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("notifyView", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // aufgabe7/blatt7.gen/CorbaForumView/notifyView
       {
         blatt7.gen.PositionedAvatar folks[] = blatt7.gen.FolksHelper.read (in);
         this.notifyView (folks);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:aufgabe7/blatt7.gen/CorbaForumView:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public CorbaForumView _this() 
  {
    return CorbaForumViewHelper.narrow(
    super._this_object());
  }

  public CorbaForumView _this(org.omg.CORBA.ORB orb) 
  {
    return CorbaForumViewHelper.narrow(
    super._this_object(orb));
  }


} // class CorbaForumViewPOA
