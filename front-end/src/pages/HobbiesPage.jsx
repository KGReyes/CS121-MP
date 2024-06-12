import {useEffect, useState} from "react";

const HobbiesPage = ({isaId = 1, kofiId = 2, nicoId = 3}) => {

    const [isaHobbies, setIsaHobbies] = useState([]);
    const [kofiHobbies, setKofiHobbies] = useState([]);
    const [nicoHobbies, setNicoHobbies] = useState([]);
    const [isaName, setIsaName] = useState('');
    const [kofiName, setKofiName] = useState('');
    const [nicoName, setNicoName] = useState('');

    useEffect(() => {
        // Fetch user details
        fetch(`http://localhost:8080/api/v1/member/${isaId}`)
            .then(response => response.json())
            .then(data => setIsaName(data.name))
            .catch(error => console.error('Error fetching user details:', error));

        fetch(`http://localhost:8080/api/v1/member/${kofiId}`)
            .then(response => response.json())
            .then(data => setKofiName(data.name))
            .catch(error => console.error('Error fetching user details:', error));

        fetch(`http://localhost:8080/api/v1/member/${nicoId}`)
            .then(response => response.json())
            .then(data => setNicoName(data.name))
            .catch(error => console.error('Error fetching user details:', error));

        // Fetch hobbies
        fetch(`http://localhost:8080/api/v1/hobbies/member/${isaId}`)
            .then(response => response.json())
            .then(data => setIsaHobbies(data))
            .catch(error => console.error('Error fetching hobbies:', error));

        fetch(`http://localhost:8080/api/v1/hobbies/member/${kofiId}`)
            .then(response => response.json())
            .then(data => setKofiHobbies(data))
            .catch(error => console.error('Error fetching hobbies:', error));

        fetch(`http://localhost:8080/api/v1/hobbies/member/${nicoId}`)
            .then(response => response.json())
            .then(data => setNicoHobbies(data))
            .catch(error => console.error('Error fetching hobbies:', error));
    }, [isaId, kofiId, nicoId]);

    return (
        <>
            <section>
                <div className="container mx-auto p-4">
                    <h1 className="text-2xl mb-4">Hobbies for {isaName}</h1>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {isaHobbies.map(hobby => (
                            <div key={hobby.id} className="border p-4 rounded-lg">
                                <strong>{hobby.name}</strong>
                                <p>{hobby.description}</p>
                                <div>
                                    {hobby.media ? (
                                        <img src={hobby.media} alt={`${hobby.name} media`} className="w-full h-auto"/>
                                    ) : (
                                        <p>No media available</p>
                                    )}
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
                <div className="container mx-auto p-4">
                    <h1 className="text-2xl mb-4">Hobbies for {kofiName}</h1>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {kofiHobbies.map(hobby => (
                            <div key={hobby.id} className="border p-4 rounded-lg">
                                <strong>{hobby.name}</strong>
                                <p>{hobby.description}</p>
                                <div>
                                    {hobby.media ? (
                                        <img src={hobby.media} alt={`${hobby.name} media`} className="w-full h-auto"/>
                                    ) : (
                                        <p>No media available</p>
                                    )}
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
                <div className="container mx-auto p-4">
                    <h1 className="text-2xl mb-4">Hobbies for {nicoName}</h1>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {nicoHobbies.map(hobby => (
                            <div key={hobby.id} className="border p-4 rounded-lg">
                                <strong>{hobby.name}</strong>
                                <p>{hobby.description}</p>
                                <div>
                                    {hobby.media ? (
                                        <img src={hobby.media} alt={`${hobby.name} media`} className="w-full h-auto"/>
                                    ) : (
                                        <p>No media available</p>
                                    )}
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
            </section>

        </>
    );
};
export default HobbiesPage