import SpotifyPlayer from "../SpotifyPlayer.jsx";
import React, { useState, useEffect } from 'react';
import Footer from "../components/Footer.jsx";

const MusicPage = ({isaId = 1, kofiId = 2, nicoId = 3}) => {

    const [isaMusic, setIsaMusic] = useState([]);
    const [kofiMusic, setKofiMusic] = useState([]);
    const [nicoMusic, setNicoMusic] = useState([]);
    const [isaName, setIsaName] = useState('');
    const [kofiName, setKofiName] = useState('');
    const [nicoName, setNicoName] = useState('');

    useEffect(() => {

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
            {/*Each member has their own section tag here too*/}
            <section>
                <div className="m-5 flex max-h-fit bg-cream-0 rounded-lg shadow-lg">
                    {/*This div is just a div within the section encompassing the things under it*/}
                    <div className="container mx-auto p-4">
                        <h1 className="text-2xl mb-4">{isaName}'s Top 5 Songs of 2024</h1>
                        {/*Each div like this encompasses the space all the songs will take*/}
                        {/*Should automatically adjust cuz of the grid thing so mess around with it I guess*/}
                        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                            {isaMusic.map(music => (
                                // Each song will get their own div arrangement, etc.
                                <div key={music.id} className="bg-cream-1 border p-4 border-cream-1 rounded-lg flex flex-col items-center text-center">
                                    <strong>{music.title}</strong>
                                    <div>by {music.artist} - {music.album}</div>
                                    <div className="m-1">
                                        <img src={music.albumart} width={250} height={250}
                                             alt={`${music.title} album art`}/>
                                    </div>
                                    {/*You can change the spotify stuff in the spotifyplayer jsx file*/}
                                    <SpotifyPlayer
                                        embedLink={`https://open.spotify.com/embed/track/${music.spotify.split('track/')[1].split('?')[0]}`}/>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </section>

            <section>
                <div className="m-5 flex max-h-fit bg-cream-0 rounded-lg shadow-lg">
                    <div className="container mx-auto p-4">
                        <h1 className="text-2xl mb-4">{kofiName}'s Top 5 Songs of 2024</h1>
                        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                            {kofiMusic.map(music => (
                                <div key={music.id} className="bg-cream-1 border p-4 border-cream-1 rounded-lg flex flex-col items-center text-center">
                                    <strong>{music.title}</strong>
                                    <div>by {music.artist} - {music.album}</div>
                                    <div className="items-center m-2">
                                        <img src={music.albumart} width={250} height={250}
                                             alt={`${music.title} album art`}/>
                                    </div>
                                    <SpotifyPlayer
                                        embedLink={`https://open.spotify.com/embed/track/${music.spotify.split('track/')[1].split('?')[0]}`}/>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </section>


            <section>
                <div className="m-5 flex max-h-fit bg-cream-0 rounded-lg shadow-lg">
                    <div className="container mx-auto p-4">
                        <h1 className="text-2xl mb-4">{nicoName}'s Top 5 Songs of 2024</h1>
                        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                            {nicoMusic.map(music => (
                                <div key={music.id} className="bg-cream-1 border p-4 border-cream-1 rounded-lg flex flex-col items-center text-center">
                                    <strong>{music.title}</strong>
                                    <div>by {music.artist} - {music.album}</div>
                                    <div className="m-1">
                                        <img src={music.albumart} width={250} height={250}
                                             alt={`${music.title} album art`} className= ""/>
                                    </div>
                                    <SpotifyPlayer
                                        embedLink={`https://open.spotify.com/embed/track/${music.spotify.split('track/')[1].split('?')[0]}`}/>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </section>

            <Footer />
        </>
    )
};
export default MusicPage