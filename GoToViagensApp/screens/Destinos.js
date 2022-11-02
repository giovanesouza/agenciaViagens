import React, { Component } from 'react';
import { View, Text, StyleSheet, Image, Button } from 'react-native';

class Destinos extends Component {

    constructor(props) {
        super(props);
        this.state = { destino: [] };
    }

    componentDidMount() {
        fetch('https://localhost:44342/api/Destino')
            .then(response => response.json())
            .then(data => this.setState({ destino: data }));
    }

    render() {
        const { destino } = this.state;

        const destinosList = destino.map(destinos => {
            return (

                <View style={styles.space}>

                    <Image
                        source={{ uri: destinos.imagem }} style={styles.img} />

                    <View style={styles.descricao}>
                        <Text style={styles.texto}>Id do destino: {destinos.destinoId}</Text> 
                        <Text style={styles.embarque}>Embarque: {destinos.embarque}</Text>
                        <Text style={styles.destino}>Destino: {destinos.destino}</Text>
                        <Text style={styles.texto}>Data ida: {destinos.destino}</Text>
                        <Text style={styles.texto}>Data volta: {destinos.dataIda}</Text>
                        <Text style={styles.texto}>Data volta: {destinos.dataVolta}</Text>
                        <Text style={styles.texto}>Preço: R$ {destinos.preco}</Text>
                        <Text style={styles.texto}>Condição: {destinos.condicao}</Text>
                        <Text style={styles.texto}>Quantidade disponível: {destinos.quantidadeDisponivel}</Text>
                        <Text style={styles.texto}>Categoria: {destinos.categoria}</Text>
                        <Button title='Comprar'/>

                    </View>

                </View>
            )
        });

        return (
            <View style={styles.container}>

                <Text>DESTINOS DISPONÍVEIS</Text>

                {destinosList}

            </View>
        )

    }
}

export default Destinos;


const styles = StyleSheet.create({
    container: {
        display: 'flex',
        alignItems: 'center',
        marginTop: 10,
        marginBottom: 10,
        backgroundColor: '#fff',
        borderTopWidth: 0,
        borderBottomWidth: 0,

    },
    space: {
        marginTop: 10,
        borderTopWidth: 1,
        borderBottomWidth: 1,
        borderRightWidth: 1,
        borderLeftWidth: 1,
        
        backgroundColor: '#fff'
    },
    img: {
        width: 200,
        height: 200
    },
    descricao: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        padding: 10,
        gap: 5
    },
    texto: {
        color: '#000'
    },

});