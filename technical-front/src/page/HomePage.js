import React, { useEffect, useState } from 'react';

import { ProductService } from '../service/ProductService';
import { Navbar, Container, Form, Button } from 'react-bootstrap';


const HomePage = () => {

  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [status, setStatus] = useState(false);

  const [tasks, setTasks] = useState([]);
  const [task, setTask] = useState([]);

  useEffect(() => {
    getTasks();
  }, []);

  const getTasks = () => {
    ProductService.getTask().then(value => setTasks(value));
  };

  const createTask = async (e) => {
    e.preventDefault();
    ProductService.createTask({
      'title': name,
      'description': description
    }).then(value => setTasks([...tasks, value]));
  }

  const updateTask = async (e) => {
    e.preventDefault();
    ProductService.updateTask(task).then(value => setTasks(tasks.map((taskMap) =>
      taskMap.id === value.id ? { ...taskMap, title: value.title, description: value.description, status: value.status } : taskMap
    )));
    setTask('');
  }

  const deleteTask = (id) => {
    ProductService.deleteTask(id);
    setTasks(tasks.filter(task => task.id !== id));
  }

  const createForm = () => {
    return <div className="container mt-5">
    <h2>Formulario de Tarea</h2>
    <Form onSubmit={createTask}>
      <Form.Group className="mb-3" controlId="formName">
        <Form.Label>Nombre de tarea</Form.Label>
        <Form.Control
          type="text"
          placeholder="Ingresa tu nombre"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formDescription">
        <Form.Label>Descripcion</Form.Label>
        <Form.Control
          type="Description"
          placeholder="Ingresa tu correo"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          required
        />
      </Form.Group>
      <Button variant="primary" type="submit">
        Enviar
      </Button>
    </Form>
  </div>;
  }

  const updateForm = (task) => {
    return <div className="container mt-5">
    <h2>Actualizar Formulario de Tarea</h2>
    <Form onSubmit={updateTask}>
      <Form.Group className="mb-3" controlId="formName">
        <Form.Label>Nombre de tarea</Form.Label>
        <Form.Control
          type="text"
          placeholder="Ingresa tu nombre"
          value={task.title}
          onChange={(e) => setTask({...task, title: e.target.value})}
          required
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formDescription">
        <Form.Label>Descripcion</Form.Label>
        <Form.Control
          type="Description"
          placeholder="Ingresa tu correo"
          value={task.description}
          onChange={(e) => setTask({...task, description: e.target.value})}
          required
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formStatus">
        <Form.Label>Status</Form.Label>
        <Form.Switch
          checked={task.status}
          onChange={() => setTask({...task, status:!task.status})}
        />
      </Form.Group>
      <Button variant="primary" type="submit">
        Enviar
      </Button>
    </Form>
  </div>;
  }



  return (
    <div className="Home">
      <div>
        {/* Menú de Navegación */}
        <Navbar bg="dark" variant="dark" expand="lg">
          <Container>
            <Navbar.Brand href="#">CRUD</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
          </Container>
        </Navbar>

        {/* Formulario */}
        {task.id == null ? createForm() : updateForm(task)}

        <div className="container mt-5">
          <h2> Tabla de Tareas </h2>
          <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Titulo</th>
                <th scope="col">Description</th>
                <th scope='col'>Estado</th>
                <th scope="col">Editar</th>
                <th scope="col">Eliminar</th>
              </tr>
            </thead>
            <tbody>
              {tasks.length > 0 ? (
                tasks.map((task, index) => (
                  <tr key={task.id}>
                    <th scope="row">{index + 1}</th>
                    <td>{task.title}</td>
                    <td>{task.description}</td>
                    <td>{task.status ? 'OK' : 'TO DO'}</td>
                    <td>
                      {/* Aquí se pueden agregar botones para editar */}
                      <button onClick={() => setTask(task)} className="btn btn-warning">Editar</button>
                    </td>
                    <td>
                      {/* Aquí se pueden agregar botones para eliminar */}
                      <button onClick={() => deleteTask(task.id)} className="btn btn-danger">Eliminar</button>
                    </td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="5" className="text-center">No hay tareas disponibles.</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default HomePage;