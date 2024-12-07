
import axios from 'axios';

const API_URL = 'http://localhost:8080';


// Función para obtener los task
const getTask = async () => {
    try {
        const response = await axios.get(`${API_URL}/api/tasks`);
        return response.data;
    } catch (error) {
        throw new Error('Error al obtener los task');
    }
}

// Función para enviar un nuevo post
const createTask = async (postData) => {
    try {
        const response = await axios.post(`${API_URL}/api/task`, postData);
        return response.data;
    } catch (error) {
        throw new Error('Error al crear el post');
    }
}

// Función para eliminar un post
const deleteTask = async (postId) => {
    try {
        const response = await axios.delete(`${API_URL}/api/task/${postId}`);
        return response.data;
    } catch (error) {
        throw new Error('Error al eliminar el post');
    }
}

// Función para editar un post
const updateTask = async (task) => {
    try {
        const response = await axios.put(`${API_URL}/api/task`, task);
        return response.data;
    } catch (error) {
        throw new Error('Error al eliminar el post');
    }
}


export const ProductService = {
    getTask,
    createTask,
    deleteTask,
    updateTask
};