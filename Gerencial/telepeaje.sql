
-- Base de datos: `telepeaje`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cobrotelepeaje`
--

CREATE TABLE `cobrotelepeaje` (
  `idCobroTelepeaje` int(11) NOT NULL,
  `valor` float NOT NULL,
  `Vehiculo_placa` varchar(45) NOT NULL,
  `fechaCobro` date NOT NULL,
  `categoriacarro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cobrotelepeaje`
--

INSERT INTO `cobrotelepeaje` (`idCobroTelepeaje`, `valor`, `Vehiculo_placa`, `fechaCobro`, `categoriacarro`) VALUES
(1, 3333, '22', '2017-10-06', 6),
(2, 444, '22', '2017-10-06', 2),
(3, 44, '22', '2017-11-06', 4),
(4, 44444, '22', '2017-11-06', 2),
(5, 333, '22', '2017-11-06', 4),
(8, 333, '22', '2017-11-06', 2),
(9, 4, '22', '2017-11-06', 3),
(10, 5, '22', '2017-11-06', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recargatelepeaje`
--

CREATE TABLE `recargatelepeaje` (
  `idRecargaTelepeaje` int(11) NOT NULL,
  `valor` float NOT NULL,
  `Vehiculo_placa` varchar(45) NOT NULL,
  `fechaRecarga` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recargatelepeaje`
--

INSERT INTO `recargatelepeaje` (`idRecargaTelepeaje`, `valor`, `Vehiculo_placa`, `fechaRecarga`) VALUES
(1, 3005.55, '22', '2017-11-06'),
(2, 20000, '22', '2017-11-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `idVehiculo` int(11) NOT NULL,
  `placa` varchar(45) NOT NULL,
  `categoria` int(11) NOT NULL,
  `saldo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`idVehiculo`, `placa`, `categoria`, `saldo`) VALUES
(4, '22', 3, 20041),
(5, '1', 2, 33),
(6, '2', 1, 44),
(22, '4', 1, 454),
(23, '5', 3, 4554),
(24, '6', 1, 4054),
(25, '7', 3, 45454);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cobrotelepeaje`
--
ALTER TABLE `cobrotelepeaje`
  ADD PRIMARY KEY (`idCobroTelepeaje`),
  ADD KEY `fk_CobroTelepeaje_Vehiculo_idx` (`Vehiculo_placa`);

--
-- Indices de la tabla `recargatelepeaje`
--
ALTER TABLE `recargatelepeaje`
  ADD PRIMARY KEY (`idRecargaTelepeaje`),
  ADD KEY `fk_RecargaTelepeaje_Vehiculo1_idx` (`Vehiculo_placa`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`idVehiculo`),
  ADD UNIQUE KEY `placa_UNIQUE` (`placa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cobrotelepeaje`
--
ALTER TABLE `cobrotelepeaje`
  MODIFY `idCobroTelepeaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `recargatelepeaje`
--
ALTER TABLE `recargatelepeaje`
  MODIFY `idRecargaTelepeaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `idVehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cobrotelepeaje`
--
ALTER TABLE `cobrotelepeaje`
  ADD CONSTRAINT `fk_CobroTelepeaje_Vehiculo` FOREIGN KEY (`Vehiculo_placa`) REFERENCES `vehiculo` (`placa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recargatelepeaje`
--
ALTER TABLE `recargatelepeaje`
  ADD CONSTRAINT `fk_RecargaTelepeaje_Vehiculo1` FOREIGN KEY (`Vehiculo_placa`) REFERENCES `vehiculo` (`placa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
