-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-05-2023 a las 04:03:22
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectogps`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `id` varchar(20) NOT NULL,
  `rut_cliente` varchar(12) DEFAULT NULL,
  `forma_pago` varchar(50) DEFAULT NULL,
  `cantidad_pro` int(11) DEFAULT NULL,
  `total_pagar` int(11) DEFAULT NULL,
  `detalles` varchar(200) DEFAULT NULL,
  `estado` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `rut` varchar(12) NOT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `fecha_nac` varchar(10) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`rut`, `nombres`, `apellidos`, `fecha_nac`, `correo`, `telefono`, `direccion`) VALUES
('11.111.111-1', 'Negra', 'Black', '11-11-2000', 'negra@ubiobio.cl', '111111111', 'calle afasdfsadfsa 12'),
('20.008.370-9', ' Martín P ', 'Villalobos O', '11-12-1998', 'martin.villalobos1901@alumnos.ubiobio.cl', '990891825', 'Por ahi'),
('22.222.222.2', 'Mario Lider', 'Cifuentes', '22-2-2002', 'mario@biobip.cl', '22222222', 'calle cifuentes 123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contiene`
--

CREATE TABLE `contiene` (
  `id` varchar(20) NOT NULL,
  `carrito_id` varchar(20) NOT NULL,
  `producto_sku` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `sku` varchar(20) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `imagen` varchar(300) NOT NULL,
  `color` varchar(20) DEFAULT NULL,
  `material` varchar(20) DEFAULT NULL,
  `modelo` varchar(50) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`sku`, `tipo`, `descripcion`, `imagen`, `color`, `material`, `modelo`, `precio`, `cantidad`) VALUES
('123aaa', 'Carcasa', 'CARCASA IPHONE 14 PRO EDICION LOS SIMPSONS', 'https://i.ibb.co/f1t058M/c3.png', 'Red', 'Plastico', 'S22', 1000, 5),
('bbbb222', 'Carcasa', 'IPHONE 14 PRO EDICION BAD BUNNY', 'https://i.ibb.co/svVgjg6/c1.png', 'Blue', 'metal', 'Iphone 12', 20000, 10),
('ccc222', 'Carcasa', 'CARCASA IPHONE 14 PRO EDICION SUPER MARIO', 'https://i.ibb.co/pySWwBZ/c2.png', 'Yellow', 'Plastico', 'Xiaomi 2', 6000, 20),
('ddd222', 'Carcasa', 'CARCASA IPHONE 14 EDICION VEGETA', 'https://i.ibb.co/VLZ0X2L/c4.png', 'Brown', 'Plastico', 'Xiaomi 2', 6000, 20),
('eee', 'Carcasa', 'CARCASA IPHONE 14 PRO EDICION STICH', 'https://i.ibb.co/B6s17C8/molde-aurora-4.png', 'Orange', 'Plastico', 'Xiaomi 2', 6000, 20),
('fff', 'Carcasa', 'CARCASA IPHONE 14 PRO EDICION MAJIN BUU', 'https://i.ibb.co/z45HdLs/molde-aurora-5.png', 'Black', 'Plastico', 'Xiaomi 2', 6000, 20);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rut_cliente` (`rut_cliente`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD PRIMARY KEY (`id`),
  ADD KEY `carrito_id` (`carrito_id`),
  ADD KEY `producto_sku` (`producto_sku`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`sku`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD FOREIGN KEY (`rut_cliente`) REFERENCES `cliente` (`rut`);

--
-- Filtros para la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD FOREIGN KEY (`carrito_id`) REFERENCES `carrito` (`id`),
  ADD FOREIGN KEY (`producto_sku`) REFERENCES `productos` (`sku`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
