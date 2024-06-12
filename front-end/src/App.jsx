import {
    Route,
    createBrowserRouter,
    createRoutesFromElements,
    RouterProvider,
} from 'react-router-dom';
import HomePage from "./pages/HomePage.jsx";
import MainLayout from "./layouts/MainLayout.jsx";
import NotFoundPage from "./pages/NotFoundPage.jsx";
import HobbiesPage from "./pages/HobbiesPage.jsx";
import MusicPage from "./pages/MusicPage.jsx";
import ToDoPage from "./pages/ToDoPage.jsx";

const router = createBrowserRouter(
    createRoutesFromElements(
        <Route path = '/' element = {<MainLayout />}>
            <Route index element = {<HomePage />}/>
            <Route path = '/hobbies' element = {<HobbiesPage />} />
            <Route path = '/music' element = {<MusicPage />} />
            <Route path = '/to-do' element = {<ToDoPage />} />
            <Route path = '*' element = {<NotFoundPage />} />
        </Route>
    )
);

const App = () => {
    return <RouterProvider router={router}/>
};
export default App