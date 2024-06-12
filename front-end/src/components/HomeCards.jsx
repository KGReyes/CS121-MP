import Card from "./Card.jsx";
import {Link} from 'react-router-dom';
const HomeCards = () => {
    return (

            <section className="py-4">
                <div className="container-xl lg:container m-auto">
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4 p-4 rounded-lg">
                        <Card>
                            <h2 className="text-2xl font-bold">Hobbies</h2>
                            <p className="mt-2 mb-4">
                                Here are our hobbies
                            </p>
                            <Link
                                to="/hobbies"
                                className="inline-block bg-black text-white rounded-lg px-4 py-2 hover:bg-gray-700"
                            >
                                Go to Hobbies
                            </Link>
                        </Card>
                        <Card bg = 'bg-indigo-100'>
                            <h2 className="text-2xl font-bold">Music</h2>
                            <p className="mt-2 mb-4">
                                Listen to our favorite songs
                            </p>
                            <Link
                                to="/music"
                                className="inline-block bg-indigo-500 text-white rounded-lg px-4 py-2 hover:bg-indigo-600"
                            >
                                Go to Music
                            </Link>
                        </Card>
                        <Card bg = 'bg-beige-100'>
                            <h2 className="text-2xl font-bold">To-Do App</h2>
                            <p className="mt-2 mb-4">
                                Try out our To-Do App
                            </p>
                            <Link
                                to="/to-do"
                                className="inline-block bg-indigo-500 text-white rounded-lg px-4 py-2 hover:bg-indigo-600"
                            >
                                Go to To-Do
                            </Link>
                        </Card>
                    </div>
                </div>
            </section>
    );
};
export default HomeCards