package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentRestController implements ControllerDoc{
	
	@Autowired
	private StudentService studentService;

	
	@Override
	@GetMapping("/students")
	public ResponseEntity<?> readAll() {
		
		HashMap<String,Object> response = new HashMap<>();
		
		List<Student> list = new LinkedList<>();
		
		try {
			
			list = studentService.findAll();
			
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta en base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("students", list);
		
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}

	@Override
	@GetMapping("/students/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		
		Student student = null;
		HashMap<String,Object> response = new HashMap<>();

		try {
			
			student =  studentService.findById(id);
			
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta en base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		if(student == null) {
			
			response.put("mensaje", "El alumno ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
			
		}

		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@Override
	@PostMapping("/students")
	public ResponseEntity<?> create(@RequestBody Student student) {
		
		HashMap<String,Object> response = new HashMap<>();

		try {
			
			studentService.save(student);
			
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al insertar los datos en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}

		response.put("mensaje", "Alumno creado con éxito.");
		response.put("alumno", student);
		
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/students/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id) {
		
		HashMap<String,Object> response = new HashMap<>();

		Student studentUpdated = studentService.findById(id);
		
		if (studentUpdated == null) {
			
			response.put("mensaje", "El alumno ".concat(id.toString().concat(" no existe en la base de datos.")));
			
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			if (student.getName() != null && !student.getName().isEmpty()) {
				
				studentUpdated.setName(student.getName());
			}
			
			if (student.getSurName() != null && !student.getSurName().isEmpty()) {
				
				studentUpdated.setSurName(student.getSurName());
			}
			
			if (student.getEmail() != null && !student.getEmail().isEmpty()) {
				
				studentUpdated.setEmail(student.getEmail());
			}
			
			String phone = Integer.toString(student.getPhoneNumber());
			
			if (phone != null && !phone.isEmpty()) {
				
				if (phone.length() == 9) {
					
					studentUpdated.setPhoneNumber(student.getPhoneNumber());
					
				} else {
					
					response.put("mensaje", "Error al introducir el número de teléfono.");
					
					return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.BAD_REQUEST);	
				}
			}
			if (student.getAddress()!= null && !student.getAddress().isEmpty()) {
				
				studentUpdated.setAddress(student.getAddress());
			}
			String postalCode = Integer.toString(student.getPostalCode());
			
			if (postalCode != null && !postalCode.isEmpty()) {
				
				if (postalCode.length() == 5) {
					
					studentUpdated.setPostalCode(student.getPostalCode());
					
				} else {
					
					response.put("mensaje", "Error al introducir el código postal.");
					
					return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.BAD_REQUEST);
				}
			}
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar el alumno en base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		studentService.save(studentUpdated);

		response.put("mensaje", "El alumno se ha actualizado con éxito.");
		response.put("alumno", studentUpdated);
		
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		HashMap<String,Object> response = new HashMap<>();

		if (studentService.findById(id) == null) {
			
			response.put("mensaje", "El alumno ".concat(id.toString().concat(" no existe en la base de datos.")));
			
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			studentService.deleteById(id);
			
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al eliminar el alumno en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El alumno se ha eliminado con éxito.");
		
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NO_CONTENT);
	}

	@Override
	@PostMapping("/students/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile file, @RequestParam("id") Long id) {
		
		HashMap<String,Object> response = new HashMap<>();
		Student student = studentService.findById(id);

		if (student == null) {
			
			response.put("mensaje", "El alumno ".concat(id.toString().concat(" no existe en la base de datos.")));
			
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (file != null && !file.isEmpty()) {
			
			String name = UUID.randomUUID().toString()+"_"+file.getOriginalFilename().replace(" ", "");
			
			Path path = Paths.get("images").resolve(name).toAbsolutePath();

			try {
				
				Files.copy(file.getInputStream(), path);

				String oldName = student.getImage();
				
				if (oldName != null && oldName.length() > 0) {
					
					Path oldPath = Paths.get("images").resolve(oldName).toAbsolutePath();
					File oldImage = oldPath.toFile();

					if (oldImage.exists() && oldImage.canRead()) {
						oldImage.delete();
						
					}
					
				}

				student.setImage(name);
				
				studentService.save(student);
				
			} catch (IOException e) {
				
				response.put("mensaje", "Error al subir la imagen del alumno.");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				
				return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response.put("alumno", student);
			
			response.put("mensaje", "Has subido correctamente la imagen: ".concat(name));
			
		}
		
		return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.CREATED);
	}

	@Override
	@GetMapping("/images/{name:.+}")
	public ResponseEntity<?> getImage(@PathVariable String name) {
		
		HashMap<String,Object> response = new HashMap<>();
		
		Path path = Paths.get("images").resolve(name).toAbsolutePath();
		
		Resource resource = null;

		try {
			resource = new UrlResource(path.toUri());
			
		} catch (MalformedURLException e) {
			
			response.put("mensaje", "Error al obtener la imagen. Revisa la URL introducida.");
			response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
			
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.BAD_REQUEST);
			
		}

		if (!resource.exists() && !resource.isReadable()) {
			
			throw new RuntimeException("No se puede cargar la imagen ".concat(name));
		}

		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+resource.getFilename()+"\"");
		
		return new ResponseEntity<Resource>(resource, cabecera, HttpStatus.OK);
	}
}
