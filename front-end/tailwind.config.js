/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {

    extend: {
      colors: {
        'off-white': '#fcfbf7',
        'beige': '#ebb587',
        'choco': '#6e4740',
        'rust': '#5d140e',
        'dark-red': '#2f0000',
        'cream-0': '#dbc6b6',
        'cream-1': '#ccb49d',
        'cream-2': '#b69e8b',
        'cream-3': '#ab9a7f',
        'cream-4': '#a18d68',
        'new-cream':'#fad4c0',
        'lav':'#c8a2c8',
      },
      fontFamily: {
        sans: ['Roboto', 'sans-serif']
      },
      gridTemplateColumns: {
        '70/30': '70% 28%',
      },
    },
  },
  plugins: [],
}