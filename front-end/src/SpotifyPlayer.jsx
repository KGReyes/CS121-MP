import React from 'react';

const SpotifyPlayer = ({ embedLink }) => {
    return (
        <div className="spotify-player mt-2 flex items-center justify-center">
            <iframe
                src={embedLink}
                width="100%"
                height="80"
                frameBorder="5"
                allowtransparency="true"
                allow="encrypted-media"
                title="Spotify Player"
            ></iframe>
        </div>
    );
};

export default SpotifyPlayer;