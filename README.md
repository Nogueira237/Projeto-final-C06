Projeto final C06<br/>
Software para gerenciamento de academia<br/>

Eduardo Nogueira Belarmino – 597 GES<br/>
Pablo Teixeira Villela dos Santos – 598 GES

========== Tutorial ==========
1. Crie uma nova Connection com o nome "academia".<br/><br/>
<img width="263" height="51" alt="image" src="https://github.com/user-attachments/assets/9f9e8e8d-61ab-455f-9e91-f2a54a93aa3f" /><br/>

2. Não é necessário alterar nada além do nome.<br/><br/>
<img width="788" height="496" alt="image" src="https://github.com/user-attachments/assets/50b051c9-5e35-4d1d-baf6-698214c7fe13" /><br/>

3. Ao entrar na connection, vá em file -> Open SQL Script<br/><br/>
<img width="263" height="311" alt="image" src="https://github.com/user-attachments/assets/37c7389c-56b3-4ef6-add7-888242f4bb13" /><br/>

4. Selecione o arquivo .sql, que se encontra dentro da pasta "sql" do projeto.<br/><br/>
<img width="1066" height="596" alt="image" src="https://github.com/user-attachments/assets/0f296785-e90f-4c9a-97df-16d994a51dc2" /><br/>

5. Por fim, execute o script uma vez.<br/><br/>
<img width="600" height="50" alt="image" src="https://github.com/user-attachments/assets/dd473c40-01fb-479c-be8e-54b757e88b59" /><br/>

6. Após abrir o projeto no IntelliJ, clique em File -> Project Structure.<br/><br/>
<img width="339" height="305" alt="image" src="https://github.com/user-attachments/assets/d0398ce0-f40d-4c2f-adc1-7c142561440d" /><br/>

7. Agora clique em Modules -> Dependencies, e depois no botão "+".<br/><br/>
<img width="663" height="243" alt="image" src="https://github.com/user-attachments/assets/121f82a3-d0b3-47a9-8c11-e2127f728a1c" /><br/>

8. Agora escolha "JARs or Directories..."<br/><br/>
<img width="202" height="123" alt="image" src="https://github.com/user-attachments/assets/5bf0b847-effc-46d4-8cd3-18f5f9217632" /><br/>

9. Selecione o arquivo .jar que se encontra dentro da pasta "lib".<br/><br/>
<img width="1023" height="570" alt="image" src="https://github.com/user-attachments/assets/05630acc-ff5b-4d60-bd9b-31dc7edac32a" /><br/>

10. Por fim, clique em OK.<br/><br/>
<img width="1025" height="704" alt="image" src="https://github.com/user-attachments/assets/82ab149e-cf5e-4bf1-a87a-4c9dabd862ff" /><br/>
<br/>
Agora o programa está pronto para ser rodado.<br/>
<br/>

========== USO DE IA ==========<br/>

1. correção do método selectAluno<br/>
- foi enviado o método ao chatGPT<br/><br/>
Resposta:<br/>
<img width="712" height="657" alt="image" src="https://github.com/user-attachments/assets/7bca9514-e5d9-4c90-b828-5915fd24a86c" /><br/>
<img width="727" height="684" alt="image" src="https://github.com/user-attachments/assets/1a7bf140-50a8-4288-9576-0ea949b304a9" /><br/>
<img width="692" height="702" alt="image" src="https://github.com/user-attachments/assets/1c442c62-0f2c-4128-ad05-aa4fc911bafe" /><br/>
<img width="696" height="707" alt="image" src="https://github.com/user-attachments/assets/07bddcb6-882c-45d2-b812-98184ef59e82" /><br/>
<img width="761" height="225" alt="image" src="https://github.com/user-attachments/assets/f3e61f24-79d7-4a64-926e-df7c92477920" /><br/>

2. Classes DAO<br/>
- Todos, exceto ConnectionDAO e AlunoDAO, foram gerados pelo chatGPT, com base na classe AlunoDAO<br/><br/>
<img width="923" height="795" alt="image" src="https://github.com/user-attachments/assets/969093c4-d6f4-4a57-b199-80bd33c8f88c" /><br/>
<img width="800" height="841" alt="image" src="https://github.com/user-attachments/assets/d47023fb-4416-4634-96fe-2aa5b782c73c" /><br/>
<img width="796" height="839" alt="image" src="https://github.com/user-attachments/assets/d7ddd1c0-8f25-4281-982d-5a5900c3b0dc" /><br/>

3. Erro de duplicação de CPF<br/>
- Erro ao inserir pessoa: Duplicate entry '12345678900' for key 'pessoa.cpf'<br/><br/>
<img width="774" height="716" alt="image" src="https://github.com/user-attachments/assets/107a6e26-3225-468c-970a-d6a4579e7461" /><br/>
<img width="634" height="840" alt="image" src="https://github.com/user-attachments/assets/208dfc64-1fe4-4226-a64a-afd9f23b1b33" /><br/>
<img width="897" height="286" alt="image" src="https://github.com/user-attachments/assets/44f697cb-79c5-467b-8e00-789bc563285d" /><br/>

4. Erro no select(mesmo existindo instâncias de aluno, esses não apareciam ao usar o método selectAluno)<br/>
- Correção pelo chatGPT<br/><br/>
<img width="831" height="416" alt="image" src="https://github.com/user-attachments/assets/17666906-0242-4601-957b-4321c0629508" /><br/>
Anteriormente era "SELECT * FROM pessoa INNER JOIN aluno ON pessoa.id = aluno.id"
<img width="835" height="429" alt="image" src="https://github.com/user-attachments/assets/568ea9ef-6e86-4334-907f-1627e5648548" /><br/>

5. Ao atualizar a tabela funcionario, a pessoa(superclasse) deveria ser atualizada junto, porém não estava atualizando<br/><br/>
<img width="727" height="756" alt="gptAtualizar pessoa alem de funcionario" src="https://github.com/user-attachments/assets/9577cde3-4b27-43b7-8afd-b3ec70af8716" /><br/>

6. Para economizar tempo, depois de fazer manualmente o código de update da classe/tabela aluno, o chatGPT gerou os códigos de update para as outras tabelas, o mesmo foi feito com os comandos delete/select<br/><br/>
<img width="530" height="821" alt="gptGeração de Update" src="https://github.com/user-attachments/assets/24340de8-4915-4e35-bdd8-a5e580b64357" /><br/>

7. O chatGPT sugeriu a inserção do atributo id nas classes Equipamento, Funcionario e Treino, para tornar mais fácil o update/delete dos dados<br/><br/>
<img width="904" height="749" alt="gptIDnasclassesquetemtabela" src="https://github.com/user-attachments/assets/c8219780-a875-41cd-97ac-bfddc3ffac59" /><br/>

8. Mostrar as opções de exercícios ao criar um novo treino<br/><br/>
<img width="710" height="812" alt="gptOPCOESDEEXERCICIO" src="https://github.com/user-attachments/assets/5e9d124a-c5b2-4e7b-88eb-329990b018ba" /><br/>
















