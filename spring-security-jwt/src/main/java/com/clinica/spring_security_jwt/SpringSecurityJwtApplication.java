package com.clinica.spring_security_jwt;

import com.clinica.spring_security_jwt.modelo.Permisos;
import com.clinica.spring_security_jwt.modelo.RoleEnum;
import com.clinica.spring_security_jwt.modelo.Roles;
import com.clinica.spring_security_jwt.modelo.Usuario;
import com.clinica.spring_security_jwt.repositorio.PermisosRepositorio;
import com.clinica.spring_security_jwt.repositorio.RolesRepositorio;
import com.clinica.spring_security_jwt.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringSecurityJwtApplication {

	@Value("${usuario.root}")
	private String usuarioRoot;

	@Value("${usuario.pass}")
	private String usuarioPass;


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}


	@Bean
	CommandLineRunner init (UsuarioRepositorio usuarioRepositorio,
							RolesRepositorio rolesRepositorio,
							PermisosRepositorio permisosRepositorio,
							PasswordEncoder passwordEncoder){

		return args -> {

			/*CREAR PERMISOS*/
			Permisos permiso1 = Permisos.builder()
					.nombre("CREATE")
					.build();
			Permisos permiso2 = Permisos.builder()
					.nombre("READ")
					.build();
			Permisos permiso3 = Permisos.builder()
					.nombre("UPDATE")
					.build();
			Permisos permiso4 = Permisos.builder()
					.nombre("DELETE")
					.build();

			if(permisosRepositorio.count() == 0) permisosRepositorio.saveAll(List.of(permiso1, permiso2, permiso3, permiso4));

			/*CREAR ROLES*/
			Roles rolAdmin = Roles.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permisos(Set.of(permiso1, permiso2, permiso3, permiso4))
					.build();

			Roles rolUser = Roles.builder()
					.roleEnum(RoleEnum.USER)
					.permisos(Set.of(permiso1, permiso2))
					.build();

			Roles rolInvited = Roles.builder()
					.roleEnum(RoleEnum.INVITED)
					.permisos(Set.of(permiso2))
					.build();

			Roles rolDeveloper = Roles.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permisos(Set.of(permiso1, permiso2, permiso3, permiso4))
					.build();



			if(rolesRepositorio.count() == 0) rolesRepositorio.saveAll(List.of(rolAdmin, rolDeveloper, rolUser, rolInvited));


			Usuario usuarioAdmin = Usuario.builder()
					.nombre(usuarioRoot)
					.password(passwordEncoder.encode(usuarioPass))
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(rolAdmin))
					.build();


			if (usuarioRepositorio.count() == 0) usuarioRepositorio.save(usuarioAdmin);
		};


	}



}
