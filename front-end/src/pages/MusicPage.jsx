import SpotifyPlayer from "../SpotifyPlayer.jsx";
import React, { useState, useEffect } from 'react';

const MusicPage = ({isaId = 1, kofiId = 2, nicoId = 3}) => {

    const [isaMusic, setIsaMusic] = useState([]);
    const [kofiMusic, setKofiMusic] = useState([]);
    const [nicoMusic, setNicoMusic] = useState([]);
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

        // Fetch music
        fetch(`http://localhost:8080/api/v1/music/member/${isaId}`)
            .then(response => response.json())
            .then(data => setIsaMusic(data))
            .catch(error => console.error('Error fetching music:', error));

        fetch(`http://localhost:8080/api/v1/music/member/${kofiId}`)
            .then(response => response.json())
            .then(data => setKofiMusic(data))
            .catch(error => console.error('Error fetching music:', error));

        fetch(`http://localhost:8080/api/v1/music/member/${nicoId}`)
            .then(response => response.json())
            .then(data => setNicoMusic(data))
            .catch(error => console.error('Error fetching music:', error));
    }, [isaId, kofiId, nicoId]);

    return (
        <>
            <section>
                <div className="container mx-auto p-4">
                    <h1 className="text-2xl mb-4">Favorite Music for {isaName}</h1>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {isaMusic.map(music => (
                            <div key={music.id} className="border p-4 rounded-lg">
                                <strong>{music.title}</strong> by {music.artist} - {music.album}
                                <div>
                                    <img src={music.albumart} width={250} height={250}
                                         alt={`${music.title} album art`}/>
                                </div>
                                <SpotifyPlayer
                                    embedLink={`https://open.spotify.com/embed/track/${music.spotify.split('track/')[1].split('?')[0]}`}/>
                            </div>
                        ))}
                    </div>
                </div>
                <div className="container mx-auto p-4">
                    <h1 className="text-2xl mb-4">Favorite Music for {kofiName}</h1>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {kofiMusic.map(music => (
                            <div key={music.id} className="border p-4 rounded-lg">
                                <strong>{music.title}</strong> by {music.artist} - {music.album}
                                <div>
                                    <img src={music.albumart} width={250} height={250}
                                         alt={`${music.title} album art`}/>
                                </div>
                                <SpotifyPlayer
                                    embedLink={`https://open.spotify.com/embed/track/${music.spotify.split('track/')[1].split('?')[0]}`}/>
                            </div>
                        ))}
                    </div>
                </div>
                <div className="container mx-auto p-4">
                    <h1 className="text-2xl mb-4">Favorite Music for {nicoName}</h1>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {nicoMusic.map(music => (
                            <div key={music.id} className="border p-4 rounded-lg">
                                <strong>{music.title}</strong> by {music.artist} - {music.album}
                                <div>
                                    <img src={music.albumart} width={250} height={250}
                                         alt={`${music.title} album art`}/>
                                </div>
                                <SpotifyPlayer
                                    embedLink={`https://open.spotify.com/embed/track/${music.spotify.split('track/')[1].split('?')[0]}`}/>
                            </div>
                        ))}
                    </div>
                </div>
            </section>
        </>
    )
};
export default MusicPage