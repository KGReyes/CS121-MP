const Card = ({children, bg = 'bg-gray-100'}) => {
    return (
        // This is where you can edit the look of the card
        <div className = {`${bg} p-6 rounded-lg shadow-md`}>
            {children}
        </div>
    );
};
export default Card