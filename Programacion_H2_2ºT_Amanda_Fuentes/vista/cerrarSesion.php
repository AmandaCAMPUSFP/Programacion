<?php
require_once '../controlador/usuarioControlador.php';

$usuarioControlador = new UsuarioControlador();
$usuarioControlador->cerrarSesion();
?>