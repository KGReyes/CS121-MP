import {NavLink} from 'react-router-dom';
import logo from '../assets/images/logo.png'
const Navbar = () => {

    // This method is just to add the black highlight on the navbar
    //changed palette to make navbar more coffee(kofi) themed lamaw

    const linkClass = ({isActive}) =>
        isActive ? 'bg-off-white  text-rust hover:bg-off-white  hover:text-rust rounded-md px-3 py-2'
            : 'text-rust hover:bg-off-white hover:text-rust rounded-md px-3 py-2'

    return(
    <>
        {/*The entire navbar is under the nav tag*/}
        <nav className="bg-beige">
            <div className="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
                <div className="flex h-20 items-center justify-between">
                    <div className="flex flex-1 justify-center md:items-stretch md:justify-start">
                        {/*Each NavLink tag corresponds to one of the options on the Navbar*/}
                        <NavLink
                            className="flex flex-shrink-0 items-center mr-4"
                            to="/">
                            <img
                                className="h-10 w-auto"
                                src={logo}
                                alt="React Jobs"
                            />
                            <span className="hidden md:block text-rust font-bold ml-2">
                                CS-121 MP
                            </span>
                        </NavLink>
                        <div className="md:ml-auto">
                            <div className="flex space-x-2">
                                <NavLink
                                    to="/"
                                    className = {linkClass}
                                >Home</NavLink>
                                <NavLink
                                    to="/hobbies"
                                    className = {linkClass}
                                >Hobbies</NavLink>
                                <NavLink
                                    to="/music"
                                    className = {linkClass}
                                >Music</NavLink>
                                <NavLink
                                    to="/to-do"
                                    className = {linkClass}
                                >To Do App</NavLink>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </>
    );
};
export default Navbar