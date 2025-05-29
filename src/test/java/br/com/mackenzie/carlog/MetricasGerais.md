## Métricas dos Testes baseados em cenários

## Contagem de cenários e testes geais

| Contagem  | Cenário                       | Condições                    
| ------    | --------------------------    | -----------------      
| 01        | 1,2,3,4,5,6                   | Informações preenchidas com os seguintes valores para *cadastro* de usuário na plataforma: {nome: Maria, cpf: 447.745.049-88, telefone: (11)98524-8925, data de nascimento: 28/12/1955, usuário: maria@gmail.com e senha: 123}
| 02        | 1,2,3,4,5,6                   | Informações preenchidas com os seguintes valores para *atualização* do usuário na plataforma: {nome: Maria Silva, cpf: 447.745.049-88, telefone: (11)98524-8925, data de nascimento: 28/12/1955, usuário: maria@gmail.com}
| 03        | 1,2,3,4,5                     | Ao tentar remover um usuário do sistema, é optada pela operação *"cencelar"*, cancelando a remoção do usuário
| 04        | 1,2,3,4,5                     | Ao tentar remover um usuário do sistema, é optada pela operação *"remover"*, removendo por completo o usuário
| 05        | 1,2,3                         | Usuário seleciona no menu a opção "Usuários", para fazer a listagem de todos os usuários cadastrados no sistema
| 06        | 1,2,3,4,5,6                   | Informações preenchidas com os seguintes valores para *cadastro* de veículo na plataforma: {marca: Hyundai, modelo: Creta, ano de fabricação: 2025, placa: DET0709, cor: preta}
| 07        | 1,2,3,4,5,6                   | Informações preenchidas com os seguintes valores para *atualização* de veículo na plataforma: {marca: Hyundai, modelo: Creta, ano de fabricação: 2024, placa: DET0709, cor: branco}
| 08        | 1,2,3,4,5                     | Ao tentar remover um veículo do sistema, é optada pela operação *"cencelar"*, cancelando a remoção do veículo
| 09        | 1,2,3,4,5                     | Ao tentar remover um veículo do sistema, é optada pela operação *"remover"*,  removendo por completo o veículo
| 05        | 1,2,3                         | Usuário seleciona no menu a opção "Veículos", para fazer a listagem de todos os veículos cadastrados no sistema

**$R_{ft}$ (Requirements for Test) = 10**

**$T_i$ (Quantidade de testes implementados) = 10**

Cobertura de Testes (implementados) = $\frac{T_i}{R_{ft}} = \frac{10}{10} = 1 = 100\%$

**$T_x$ (Quantidade de testes executados) = 10**

Cobertura de Testes (executados) = $\frac{T_x}{R_{ft}} = \frac{10}{10} = 1 = 100\%$

**$R_s$ (Quantidade de testes bem-sucedidos) = 10**

Cobertura de Testes (bem-sucedidos) = $\frac{T_s}{R_{ft}} = \frac{10}{10} = 1 = 100\%$

### Sugestões de Evolução:
- Mapear cenários de exceção ou fluxos alternativos, por exemplo:
    - Cadastro com CPF já existente.
    - Cadastro de veículo com placa duplicada.
- Registrar o tempo de execução dos testes para métricas de eficiência.
- Implementar testes automatizados para reduzir o esforço em execuções repetitivas.

### Observação: 
- Todos os fluxos principais dos casos de uso foram validados com sucesso. 