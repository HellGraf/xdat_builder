package org.sart.xdat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.bind.JAXB;
import org.sart.shell.SimpleConsole;
import org.sart.shell.exec;
import org.sart.xdat.ct0.CT0DocumentManager;
import org.sart.xdat.ct24.CT24DocumentManager;

public class Main
{
	private static final Path dtarget = Paths.get("xml");
	
	public static void main(String[] var0) throws Throwable
	{
		SimpleConsole.from(Main.class).register(EProjectType.class, EProjectType::parse).exec(var0);
	}
	
	@exec("new-project")
	public void newProject(EProjectType var1) throws URISyntaxException, IOException
	{
		this.newProjectFrom(var1, getOriginal(var1));
	}
	
	@exec("new-project-from")
	public void newProjectFrom(EProjectType var1, Path var2) throws IOException
	{
		if(!Files.notExists(var2, new LinkOption[0]) && !Files.isDirectory(var2, new LinkOption[0]))
		{
			File var3 = new File("project.xml");
			if(var3.exists())
			{
				throw new RuntimeException("already exists project.xml");
			}
			else
			{
				DocumentManager var4 = getDocumentManager(var1);
				var4.decompile(var2);
				var4.saveAsXML(dtarget);
				Project var5 = new Project();
				var5.type = var1;
				var5.src = dtarget.toAbsolutePath().toString();
				JAXB.marshal(var5, new File("project.xml"));
			}
		}
		else
		{
			throw new RuntimeException("xdat file problem");
		}
	}
	
	@exec("compile")
	public void compile()
	{
		File var1 = new File("project.xml");
		if(!var1.exists())
		{
			throw new RuntimeException("not found project.xml");
		}
		else
		{
			Project var2 = (Project)JAXB.unmarshal(var1, Project.class);
			DocumentManager var3 = getDocumentManager(var2.type);
			var3.compile(Paths.get(var2.src));
		}
	}
	
	@exec("pos")
	public void pos()
	{
		try
		{
			Path var1 = Paths.get(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
			System.out.println(var1);
		}
		catch(URISyntaxException var3)
		{
			var3.printStackTrace();
		}
		
		System.out.println(Paths.get("").toAbsolutePath());
	}
	
	private static Path getOriginal(EProjectType var0) throws URISyntaxException
	{
		var0.getClass();
		switch(var0)
		{
		case CT0:
			return Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().resolve("original/interlude.xdat");
		case CT24:
			return Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().resolve("original/epilogue.xdat");
		default:
			return null;
		}
	}
	
	private static DocumentManager getDocumentManager(EProjectType var0)
	{
		var0.getClass();
		switch(var0)
		{
		case CT0:
			return new CT0DocumentManager();
		case CT24:
			return new CT24DocumentManager();
		default:
			return null;
		}
	}
}
