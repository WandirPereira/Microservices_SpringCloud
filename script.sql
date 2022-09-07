CREATE DATABASE `mscartoes` /*!40100 DEFAULT CHARACTER SET latin1 */;
use mscartoes;
CREATE TABLE `cartao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `bandeira` varchar(30) DEFAULT NULL,
  `renda` decimal(18,2) DEFAULT NULL,
  `limiteBasico` decimal(18,2) DEFAULT NULL,
  `limite_basico` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `clientecartao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) DEFAULT NULL,
  `id_cartao` bigint(20) DEFAULT NULL,
  `limite` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TBL_CARTAO_ID_idx` (`id_cartao`),
  CONSTRAINT `FK_TBL_CARTAO_ID` FOREIGN KEY (`id_cartao`) REFERENCES `cartao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE DATABASE `msclientes` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `idade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
