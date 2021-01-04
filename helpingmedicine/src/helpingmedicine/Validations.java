package helpingmedicine;





import java.util.Scanner;

public class Validations
{

public static boolean isNumericString(String x)
{
char c[]=x.toCharArray();

for(int i=0;i<c.length;i++)
{
  if(c[i]<'0' || c[i]>'9')
   return false;
}

return true;
}

public static boolean isPincode(String x)
{
if(x.length()!=6)
return false;

if(x.startsWith("0"))
return false;

char c[]=x.toCharArray();
for(int i=0;i<c.length;i++)
{
  if(c[i]<'0' || c[i]>'9')
   return false;
}

return true;
}

public static boolean isName(String x)
{

 if(x.startsWith("."))
  return false;

 if(x.contains(".."))
   return false;

 x=x.toLowerCase();

 char c[]=x.toCharArray();
 for(int i=0;i<c.length;i++)
 {
	if(c[i]<'a' || c[i]>'z')
	   if(c[i]!='.' && c[i]!=' ')
		return false;
 }
   
  return true;
}

}