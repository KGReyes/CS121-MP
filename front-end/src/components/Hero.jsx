import kcs2 from "../assets/images/kocosa-02.png";
import kcs3 from "../assets/images/kocosa-03.png";
import kcs4 from "../assets/images/kocosa-04.png";
const Hero = () => {
    return (
        <>
            <section>
                <div className="m-5 flex max-h-screen bg-cream-0 rounded-lg shadow-lg">
                    <img
                        className="m-5 h-60 w-auto"
                        src={kcs2}
                        alt="placeholder"
                    />
                    <div className="text-start">
                        <h1 className="m-6 font-press text-black sm:text-4xl md:text-5xl">
                            Kofi Reyes
                        </h1>
                        <p className="m-6 font-sans text-gray-800 text-justify sm:text-2xl md:text-3xl">
                            Hello! I’m Kofi Gabriel Reyes. I’m a 2nd Year BS - ComSci student in UPM. As you can
                            see, this is our machine project for CS 121 - Web Programming. We poured our blood,
                            sweat, tears, bones, eyes, fingernails, or anything from our bodies, you name it! All
                            under one week! How amazing is that!
                            </p>
                        </div>
                    </div>
            </section>

            <section>
                <div className="m-5 flex max-h-screen bg-cream-2 rounded-lg shadow-lg">
                    <div className="text-end">
                        <h1 className="m-6 font-press text-black sm:text-4xl md:text-5xl">
                            Isabella Aguinaldo
                        </h1>
                        <p className="m-6 font-sans text-gray-800 text-justify sm:text-2xl md:text-3xl">
                            Hey, I'm Isa! I'm a 2nd Year BS - ComSci student in UPM. I get sick a lot and its probably
                            the burnout from this semester combined with the Taft smoke that gave me the time of my life
                            this week trying to work on this project. Also, I'm a huge nerd.
                        </p>
                    </div>
                    <img
                        className="m-5 h-60 w-auto"
                        src={kcs4}
                        alt="placeholder"
                    />
                </div>
            </section>

            <section>
                <div className="m-5 flex max-h-screen bg-cream-0 rounded-lg shadow-lg">
                    <img
                        className="m-5 h-60 w-auto"
                        src={kcs3}
                        alt="placeholder"
                    />
                    <div className="text-start">
                        <h1 className="m-6 font-press text-black sm:text-4xl md:text-5xl">
                            Nico Ferrer
                        </h1>
                        <p className="m-6 font-sans text-gray-800 text-justify sm:text-2xl md:text-3xl">
                            Hiiii, I'm Nico! I am also a 2nd Year BS - ComSci student in UPM. Finals week has made me
                            unable to sleep at a reasonable time. I spend that time playing games and doomscrolling.
                            Please send help! :DD
                        </p>
                    </div>
                </div>
            </section>
        </>
    );
};
export default Hero;