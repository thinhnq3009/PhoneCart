package eco.phonecart.app.image;

import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class Images {

	private Part part;
	private String filename;
	private String realPart;
	private String folder;

	@SuppressWarnings("unused")
	private void init(HttpServletRequest request, String inputName, String folder) {
		try {
			if (part == null) {
				part = request.getPart(inputName);
			}

			this.folder = folder.startsWith("/") ? folder : "/" + folder;

			realPart = request.getServletContext().getRealPath(folder);

			filename = Path.of(part.getSubmittedFileName()).getFileName().toString();

			if (!Files.exists(Path.of(realPart))) {
				Files.createDirectories(Path.of(realPart));
			}

			part.write(realPart + "/" + filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Images(HttpServletRequest request, String name) {

		init(request, name, "/ImageUpload");

	}

	public Images(HttpServletRequest request, String name, String folder) {

		init(request, name, folder);

	}

	public String getSrc() {
		return this.folder + "/" + this.filename;
	}
}
