-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-12-2024 a las 07:09:40
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `projexus`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaciones`
--

CREATE TABLE `asignaciones` (
  `id_asignacion` int(11) NOT NULL,
  `id_tareas` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `fecha_asignacion` datetime DEFAULT current_timestamp(),
  `fecha_entrega` datetime DEFAULT NULL,
  `estatus` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lider`
--

CREATE TABLE `lider` (
  `id_Lider` int(11) NOT NULL,
  `id_proyecto` int(11) NOT NULL,
  `id_usuarios` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lider`
--

INSERT INTO `lider` (`id_Lider`, `id_proyecto`, `id_usuarios`, `id_rol`) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1),
(3, 3, 3, 1),
(4, 4, 4, 1),
(5, 5, 5, 1),
(6, 6, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `id_Proyecto` int(11) NOT NULL,
  `tiempo_estimado` date NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `lider` int(11) NOT NULL,
  `estado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`id_Proyecto`, `tiempo_estimado`, `descripcion`, `lider`, `estado`) VALUES
(1, '2024-12-30', 'Desarrollo de una aplicación', 1, 'Iniciando'),
(2, '2025-01-15', 'Creación de un sistema de gestión', 1, 'Pendiente'),
(3, '2024-12-20', 'Implementación de un sistema contable', 3, 'En progreso'),
(4, '2025-01-10', 'Desarrollo de una API REST', 4, 'Pendiente'),
(5, '2024-12-25', 'Diseño de un sistema de reservas', 5, 'En progreso'),
(6, '2024-12-11', 'Proyecto de PowerPoint', 2, 'Finalizado'),
(12, '2024-12-09', 'Aplicación Para Crear proyectos', 3, 'En Proceso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_Rol` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_Rol`, `nombre`, `descripcion`) VALUES
(1, 'Lider', 'Aquel que guía y lidera el grupo'),
(2, 'Colaborador', 'El que colabora en el proyecto'),
(3, 'Administrador', 'Gestiona permisos y supervisa proyectos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id_Tareas` int(11) NOT NULL,
  `tiempo` datetime NOT NULL,
  `progreso` float NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_proyecto` int(11) NOT NULL,
  `descripcion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`id_Tareas`, `tiempo`, `progreso`, `id_usuario`, `id_proyecto`, `descripcion`) VALUES
(1, '2024-12-06 09:00:00', 50.5, 2, 1, 'Configurar el servidor inicial para la aplicación móvil'),
(2, '2024-12-07 14:30:00', 20, 2, 2, 'Diseñar el esquema de base de datos para el sistema de gestión'),
(3, '2024-12-10 08:00:00', 30, 4, 3, 'Integrar módulos contables con el sistema principal'),
(4, '2024-12-12 13:00:00', 50, 3, 4, 'Crear endpoints para la API de usuarios'),
(5, '2024-12-15 10:00:00', 25, 5, 5, 'Implementar la interfaz de usuario para reservas'),
(6, '2024-12-11 04:00:00', 20, 6, 3, 'Realizar pruebas de carga en el sistema');

--
-- Disparadores `tareas`
--
DELIMITER $$
CREATE TRIGGER `before_delete_tarea` BEFORE DELETE ON `tareas` FOR EACH ROW BEGIN
    -- Eliminar las asignaciones relacionadas con la tarea
    DELETE FROM asignaciones WHERE id_Tareas = OLD.id_Tareas;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_Usuarios` int(11) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nombre_de_usuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_Usuarios`, `contraseña`, `email`, `nombre_de_usuario`) VALUES
(1, '123', 'lider@correo.com', 'Lider1'),
(2, 'securepass', 'colaborador@correo.com', 'Colaborador1'),
(3, 'pass123', 'andres@correo.com', 'AndresG'),
(4, 'mypass', 'laura@correo.com', 'LauraS'),
(5, 'securepwd', 'carlos@correo.com', 'CarlosM'),
(6, '12345678', 'maria@correo.com', 'MariaP'),
(7, 'mypassword', 'juan@correo.com', 'JuanR'),
(11, 'Pepe1502', 'bmopua@hotmail.com', 'Adrian'),
(12, '123456', 'Adrian@hotmail.com', 'Adrian');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  ADD PRIMARY KEY (`id_asignacion`);

--
-- Indices de la tabla `lider`
--
ALTER TABLE `lider`
  ADD PRIMARY KEY (`id_Lider`),
  ADD KEY `id_proyecto` (`id_proyecto`),
  ADD KEY `id_usuarios` (`id_usuarios`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id_Proyecto`),
  ADD KEY `lider` (`lider`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_Rol`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id_Tareas`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_proyecto` (`id_proyecto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_Usuarios`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignaciones`
--
ALTER TABLE `asignaciones`
  MODIFY `id_asignacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `lider`
--
ALTER TABLE `lider`
  MODIFY `id_Lider` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `id_Proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_Rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `id_Tareas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_Usuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lider`
--
ALTER TABLE `lider`
  ADD CONSTRAINT `lider_ibfk_1` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_Proyecto`),
  ADD CONSTRAINT `lider_ibfk_2` FOREIGN KEY (`id_usuarios`) REFERENCES `usuarios` (`id_Usuarios`),
  ADD CONSTRAINT `lider_ibfk_3` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_Rol`);

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `proyecto_ibfk_1` FOREIGN KEY (`lider`) REFERENCES `usuarios` (`id_Usuarios`);

--
-- Filtros para la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD CONSTRAINT `tareas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_Usuarios`),
  ADD CONSTRAINT `tareas_ibfk_2` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_Proyecto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
