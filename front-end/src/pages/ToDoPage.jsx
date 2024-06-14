import React, { useState } from 'react';
import Footer from "../components/Footer.jsx";
const ToDoPage = () => {
    const [toDo, setToDo] = useState([]);
    const [newtoDo, setNewTodo] = useState({ category: '#', job: '', description: '' });
    const [filterCategory, setFilterCategory] = useState('all');
    const [selectedtoDo, setSelectedTodos] = useState([]);
    const [error, setError] = useState('');

    const fetchToDo = () => {
        fetch(`http://localhost:8080/api/v1/todo`)
            .then(response => response.json())
            .then(data => setToDo(Array.isArray(data) ? data : []))
            .catch(error => setError('Error fetching todos: ' + error));
    };

    const handleAdd = () => {
        fetch(`http://localhost:8080/api/v1/todo`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ ...newtoDo })
        })
            .then(() => {
                setNewTodo({ category: '#', job: '', description: '' });
                fetchToDo();
            })
            .catch(error => setError('Error adding todo: ' + error));
    };

    const handleDeletion = () => {
        selectedtoDo.forEach(todoId => {
            fetch(`http://localhost:8080/api/v1/todo/${todoId}`, {
                method: 'DELETE'
            })
                .then(() => fetchToDo())
                .catch(error => setError('Error deleting todo: ' + error));
        });
        setSelectedTodos([]);
    };

    const handleDoneToggle = (todoId, done) => {
        fetch(`http://localhost:8080/api/v1/todo/${todoId}/done?done=${done}`, {
            method: 'PUT',
        })
            .then(() => fetchToDo())
            .catch(error => setError('Error updating todo: ' + error));
    };

    const todoSelect = toDo.filter(todo => {
        if (filterCategory !== 'all') return todo.category === filterCategory;
        return true;
    });

    const categorySelect = [...new Set(toDo.map(todo => todo.category))];


    return (
        // This div covers generally the whole page under the navbar
        <>
            <div className="mt-1 mb-1 bg-cream-2 min-h-screen w-full flex flex-col">
                <div className="m-4 bg-transparent container mx-auto p-4 flex-1">
                    <h1 className="text-center text-4xl mb-4 font-press">To-do List</h1>
                    {error && <p className="text-red-500">{error}</p>}
                    {/* This div covers the delete and the drop down category menu */}
                    {/* This div covers the form for adding a new to do */}
                    <div className="mt-4 bg-gray-800 p-4 rounded-lg">
                        <h2 className="text-lg mb-2 text-white">
                            Add to the list | Make sure each job is unique, or else it won't be
                            added!
                        </h2>
                        {/* This div covers the Job input */}
                        <div className="mb-2">
                            <label className="block text-sm font-bold mb-1 text-white">Job</label>
                            <input
                                type="text"
                                value={newtoDo.job}
                                onChange={(e) => setNewTodo({ ...newtoDo, job: e.target.value })}
                                className="border p-2 rounded w-full"
                            />
                        </div>
                        {/* This div covers the description of the job input */}
                        <div className="mb-2">
                            <label className="block text-sm font-bold mb-1 text-white">
                                Description
                            </label>
                            <input
                                type="text"
                                value={newtoDo.description}
                                onChange={(e) =>
                                    setNewTodo({ ...newtoDo, description: e.target.value })
                            }
                                className="border p-2 rounded w-full"
                            />
                        </div>
                        {/* This div covers the Category input */}
                        <div className="mb-2">
                            <label className="block text-sm font-bold mb-1 text-white">Label</label>
                            <input
                                type="text"
                                value={newtoDo.category}
                                onChange={(e) =>
                                    setNewTodo({ ...newtoDo, category: e.target.value })
                            }
                                className="border p-2 rounded w-full"
                            />
                        </div>
                        {/* Button to add the to-do from the form */}
                        <div className="flex space-x-2">
                            <button onClick={handleAdd} className="bg-blue-500 text-white px-4 py-2 rounded">
                                Add To do
                            </button>
                            <button onClick={handleDeletion} className="bg-red-500 text-white px-4 py-2 rounded">
                                Delete Selected
                            </button>
                            <select
                                value={filterCategory}
                                onChange={(e) => setFilterCategory(e.target.value)}
                                className="border p-2 rounded"
                            >
                                <option value="all">All Labels</option>
                                {categorySelect.map((category) => (
                                    <option key={category} value={category}>
                                        {category}
                                    </option>
                                ))}
                            </select>
                        </div>
                    </div>
                    {/* This div covers the selection table go make it look fancee */}
                    <div className="overflow-x-auto mt-4">
                        <div className="bg-white p-4 rounded-lg border border-gray-200 shadow-lg">
                            <table className="min-w-full">
                                <thead>
                                <tr>
                                    <th className="py-2">Select</th>
                                    <th className="py-2">Job</th>
                                    <th className="py-2">Description</th>
                                    <th className="py-2">Label</th>
                                    <th className="py-2">Status</th>
                                </tr>
                                </thead>
                                {/* tbody is the body of the table */}
                                <tbody>
                                {todoSelect.map((todo) => (
                                    <tr key={todo.id}>
                                        <td className="border px-4 py-2">
                                            <input
                                                type="checkbox"
                                                checked={selectedtoDo.includes(todo.id)}
                                                onChange={() => {
                                                    if (selectedtoDo.includes(todo.id)) {
                                                        setSelectedTodos(
                                                            selectedtoDo.filter((id) => id !== todo.id)
                                                        );
                                                    } else {
                                                        setSelectedTodos([...selectedtoDo, todo.id]);
                                                    }
                                                }}
                                            />
                                        </td>
                                        <td className="border px-4 py-2">{todo.job}</td>
                                        <td className="border px-4 py-2">{todo.description}</td>
                                        <td className="border px-4 py-2">{todo.category}</td>
                                        <td className="border px-4 py-2">
                                            <input
                                                type="checkbox"
                                                checked={todo.done}
                                                onChange={() => handleDoneToggle(todo.id, !todo.done)}
                                            />
                                        </td>
                                    </tr>
                                ))}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <Footer />
        </>
    )
};
export default ToDoPage