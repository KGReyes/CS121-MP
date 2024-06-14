import Hero from "../components/Hero.jsx";
import HomeCards from "../components/HomeCards.jsx";

const HomePage = () => {
    return (
        <>
            <Hero />
            <HomeCards />
            <section>
                <div className=" flex max-h-screen bg-beige">
                    <div className="mx-4 text-end">
                        <p className= "text-xl text-off-white">
                             CMSC 121: GROUP 1 | Aguinaldo | Ferrer | Reyes
                        </p>
                    </div>
                </div>
            </section>
        </>
    );
};
export default HomePage